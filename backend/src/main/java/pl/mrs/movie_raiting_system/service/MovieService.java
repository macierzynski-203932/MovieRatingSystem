package pl.mrs.movie_raiting_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mrs.movie_raiting_system.dao.MovieRepository;
import pl.mrs.movie_raiting_system.entities.Movie;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getFavouriteMovies(){
        return movieRepository.findAll();
    }
}
