package pl.mrs.movie_raiting_system.service;

import com.sun.deploy.util.ArrayUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mrs.movie_raiting_system.converters.TvShowDetailsConverter;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.Season;
import pl.mrs.movie_raiting_system.dto.TvShowDetails;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.MovieDetails;

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


    public TvShowDetails getTvShowInfo(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String query = "https://api.themoviedb.org/3/tv/" + id + "?api_key=" + apiKey;
        pl.mrs.movie_raiting_system.dto.theMovieDbApi.TvShowDetails result = restTemplate.getForObject(query, pl.mrs.movie_raiting_system.dto.theMovieDbApi.TvShowDetails.class);
        result.setPoster_path("http://image.tmdb.org/t/p/w200/" + result.getPoster_path());
        TvShowDetails details = TvShowDetailsConverter.getDetails(result);
        details.setSeasons(new Season[details.getNumberOfSeasons()]);

        for(int i=1; i <= details.getNumberOfSeasons(); i++) {
            query = "https://api.themoviedb.org/3/tv/" + id + "/season/" + i + "?api_key=" + apiKey;
            Season season = restTemplate.getForObject(query, Season.class);
            details.getSeasons()[i - 1] = season;
        }

        return details;
    }

}