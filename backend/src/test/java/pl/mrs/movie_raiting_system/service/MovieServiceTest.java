package pl.mrs.movie_raiting_system.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mrs.movie_raiting_system.entities.Movie;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieServiceTest extends ServiceTest{
    @TestConfiguration
    static class MovieServiceTestContextConfiguration {

        @Bean
        public MovieService movieService() {
            return new MovieService();
        }
    }

    @Autowired
    private MovieService service;

    @Before
    public void setUp() {
        init();
    }

    @Test
    public void testGetFavouriteMovies() throws EntityNotFoundException {
        List<Movie> movies = service.getFavouriteMovies();
        assertEquals(movies.get(0).getId(), movie2.getId());
        assertEquals(movies.get(0).getTitle(), movie2.getTitle());
        assertEquals(movies.get(1).getId(), movie3.getId());
        assertEquals(movies.get(1).getTitle(), movie3.getTitle());
    }
}
