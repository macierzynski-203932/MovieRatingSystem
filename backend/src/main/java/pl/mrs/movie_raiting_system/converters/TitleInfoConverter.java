package pl.mrs.movie_raiting_system.converters;

import pl.mrs.movie_raiting_system.dto.TitleInfo;
import pl.mrs.movie_raiting_system.dto.UserInfo;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.MovieInfo;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.TitleList;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.TvShowInfo;
import pl.mrs.movie_raiting_system.entities.User;

public class TitleInfoConverter {

    public static TitleInfo getTitleInfo(MovieInfo movie) {
        return TitleInfo.builder()
                .id(movie.getId())
                .voteCount(movie.getVote_count())
                .averageVote(movie.getVote_average())
                .title(movie.getTitle())
                .posterUrl("http://image.tmdb.org/t/p/w200/" + movie.getPoster_path())
                .description(movie.getOverview())
                .releaseDate(movie.getRelease_date())
                .isTvShow(false)
                .build();
    }

    public static TitleInfo getTitleInfo(TvShowInfo movie) {
        return TitleInfo.builder()
                .id(movie.getId())
                .voteCount(movie.getVote_count())
                .averageVote(movie.getVote_average())
                .title(movie.getName())
                .posterUrl("http://image.tmdb.org/t/p/w200/" + movie.getPoster_path())
                .description(movie.getOverview())
                .releaseDate(movie.getFirst_air_date())
                .isTvShow(true)
                .build();
    }
}
