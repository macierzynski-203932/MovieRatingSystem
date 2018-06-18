package pl.mrs.movie_raiting_system.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.mrs.movie_raiting_system.dto.UserInfo;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.Genre;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.MovieDetails;
import pl.mrs.movie_raiting_system.service.DetailsService;
import pl.mrs.movie_raiting_system.service.UserService;

import javax.swing.text.html.parser.Entity;
import javax.xml.ws.Response;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DetailsRestTest.class)
@EnableSpringDataWebSupport
@WithMockUser
public class DetailsRestTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private DetailsService detailsService;

    private boolean initialized = false;

    //Can't use @BeforeClass because mvc and service can't be static
    @Before
    public void setUp() {
        if(!initialized) {
            MovieDetails movieDetail = MovieDetails.builder()
                    .id(1)
                    .budget(50000)
                    .overview("sth")
                    .poster_path("sth_sth")
                    .release_date("date")
                    .title("title")
                    .vote_average(5.0)
                    .vote_count(10)
                    .build();

            given(detailsService.getMovieInfo(1L)).willReturn(movieDetail);

            initialized = true;
        }
    }

    @Test
    public void testGetMovieDetails() throws Exception {
        //ISSUE 404
    }
}
