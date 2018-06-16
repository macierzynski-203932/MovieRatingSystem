package pl.mrs.movie_raiting_system.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mrs.movie_raiting_system.converters.TitleInfoConverter;
import pl.mrs.movie_raiting_system.dto.TitleInfo;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.MovieDetails;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.MovieList;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.TvShowList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DetailsService {
    private String apiKey = "28687a8a2665a5be8f7fc9534674e52f";

    public MovieDetails getMovieInfo(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String query = "https://api.themoviedb.org/3/movie/" + id + "?api_key=" + apiKey;
        MovieDetails result = restTemplate.getForObject(query, MovieDetails.class);
        result.setPoster_path("http://image.tmdb.org/t/p/w200/" + result.getPoster_path());

        return result;
    }

}