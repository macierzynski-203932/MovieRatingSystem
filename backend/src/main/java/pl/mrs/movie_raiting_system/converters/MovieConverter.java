package pl.mrs.movie_raiting_system.converters;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.MovieDetails;
import pl.mrs.movie_raiting_system.entities.Movie;

public class MovieConverter {

    public static Movie toMovie(MovieDetails newmovie){
            Movie movie = new Movie();
            movie.setId(new Long(newmovie.getId()));
            movie.setBudget(new Long(newmovie.getBudget()));
            movie.setOverview(newmovie.getOverview());
            movie.setPoster_path(newmovie.getPoster_path());
            movie.setRelease_date(newmovie.getRelease_date());
            movie.setTitle(newmovie.getTitle());
            movie.setVote_average(newmovie.getVote_average());
            movie.setVote_count(newmovie.getVote_count());
        return movie;
    }

}
