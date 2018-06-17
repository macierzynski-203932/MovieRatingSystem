package pl.mrs.movie_raiting_system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mrs.movie_raiting_system.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
