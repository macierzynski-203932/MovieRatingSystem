package pl.mrs.movie_raiting_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mrs.movie_raiting_system.converters.TitleInfoConverter;
import pl.mrs.movie_raiting_system.converters.UserInfoConverter;
import pl.mrs.movie_raiting_system.dao.UserRepository;
import pl.mrs.movie_raiting_system.dto.TitleInfo;
import pl.mrs.movie_raiting_system.dto.UserInfo;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.MovieList;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.TvShowList;
import pl.mrs.movie_raiting_system.entities.User;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TitlesService {
    private String apiKey = "28687a8a2665a5be8f7fc9534674e52f";

    public List<TitleInfo> searchForTitles(String query) {
        List<TitleInfo> result = searchForMovies(query);
        result.addAll(searchForTvShows(query));
        return result;
    }

    private List<TitleInfo> searchForMovies(String query) {
        StringBuilder url = new StringBuilder("https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=");
        url.append(query);

        RestTemplate restTemplate = new RestTemplate();
        MovieList result = restTemplate.getForObject(url.toString(), MovieList.class);
        List<TitleInfo> titles = new ArrayList<>();
        Arrays.stream(result.getResults())
                .forEach(movieInfo -> titles.add(TitleInfoConverter.getTitleInfo(movieInfo)));

        for (int i = 1; i < result.getTotal_pages(); i++) {
            url = new StringBuilder("https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=");
            url.append(query)
                    .append("&page=")
                    .append(i);
            result = restTemplate.getForObject(url.toString(), MovieList.class);
            Arrays.stream(result.getResults())
                    .forEach(movieInfo -> titles.add(TitleInfoConverter.getTitleInfo(movieInfo)));
        }

        return titles;
    }

    private List<TitleInfo> searchForTvShows(String query) {
        StringBuilder url = new StringBuilder("https://api.themoviedb.org/3/search/tv?api_key=" + apiKey + "&query=");
        url.append(query);

        RestTemplate restTemplate = new RestTemplate();
        TvShowList result = restTemplate.getForObject(url.toString(), TvShowList.class);
        List<TitleInfo> titles = new ArrayList<>();
        Arrays.stream(result.getResults())
                .forEach(movieInfo -> titles.add(TitleInfoConverter.getTitleInfo(movieInfo)));

        for (int i = 1; i < result.getTotal_pages(); i++) {
            url = new StringBuilder("https://api.themoviedb.org/3/search/tv?api_key=" + apiKey + "&query=");
            url.append(query)
                    .append("&page=")
                    .append(i);
            result = restTemplate.getForObject(url.toString(), TvShowList.class);
            Arrays.stream(result.getResults())
                    .forEach(movieInfo -> titles.add(TitleInfoConverter.getTitleInfo(movieInfo)));
        }

        return titles;
    }
}