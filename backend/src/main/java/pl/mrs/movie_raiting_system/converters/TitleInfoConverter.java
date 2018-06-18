package pl.mrs.movie_raiting_system.converters;

import pl.mrs.movie_raiting_system.dto.TitleInfo;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.MovieInfo;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.TvShowInfo;

public class TitleInfoConverter {

    public static TitleInfo getTitleInfo(MovieInfo movie) {
        return TitleInfo.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .posterUrl("http://image.tmdb.org/t/p/w200/" + movie.getPoster_path())
                .isTvShow(false)
                .build();
    }

    public static TitleInfo getTitleInfo(TvShowInfo movie) {
        return TitleInfo.builder()
                .id(movie.getId())
                .title(movie.getName())
                .posterUrl("http://image.tmdb.org/t/p/w200/" + movie.getPoster_path())
                .isTvShow(true)
                .build();
    }
}
