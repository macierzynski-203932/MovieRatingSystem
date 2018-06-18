package pl.mrs.movie_raiting_system.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mrs.movie_raiting_system.dto.UserInfo;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.MovieDetails;

import javax.persistence.EntityNotFoundException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DetailsServiceTest extends ServiceTest{
    @TestConfiguration
    static class DetailsServiceTestContextConfiguration {

        @Bean
        public DetailsService detailsService() {
            return new DetailsService();
        }
    }

    @Autowired
    private DetailsService service;

    @Before
    public void setUp() {
        init();
    }

    @Test
    public void testGetMovieInfo() throws EntityNotFoundException {
        MovieDetails movie = service.getMovieInfo(Long.valueOf(movie1.getId()));
        assertEquals(movie.getId(), movie1.getId());
        assertEquals(movie.getTitle(), movie1.getTitle());
        assertEquals(movie.getVote_average(), movie1.getVote_average());
    }
}
