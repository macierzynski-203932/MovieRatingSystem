package pl.mrs.movie_raiting_system.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.MovieDetails;
import pl.mrs.movie_raiting_system.entities.Movie;
import pl.mrs.movie_raiting_system.service.DetailsService;
import pl.mrs.movie_raiting_system.service.MovieService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieRest.class)
@EnableSpringDataWebSupport
@WithMockUser
public class MovieRestTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private MovieService movieService;

    private boolean initialized = false;

    //Can't use @BeforeClass because mvc and service can't be static
    @Before
    public void setUp() {
        if(!initialized) {
            List<Movie> movies = new ArrayList<>();
            movies.add(Movie.builder().id(1L).title("Avengers").build());
            movies.add(Movie.builder().id(2L).title("Thor").build());

            given(movieService.getFavouriteMovies()).willReturn(movies);

            initialized = true;
        }
    }

    @Test
    public void testGetFavouriteMovies() throws Exception {
        mvc.perform(get("/api/movies/favourite")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[0].title", is("Avengers")))
                .andExpect(jsonPath("$[1].title", is("Thor")));
    }
}
