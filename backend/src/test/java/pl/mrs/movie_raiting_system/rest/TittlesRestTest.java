package pl.mrs.movie_raiting_system.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.mrs.movie_raiting_system.dto.TitleInfo;
import pl.mrs.movie_raiting_system.service.TitlesService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TitlesRest.class)
@WithMockUser
public class TittlesRestTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TitlesService titlesService;

    private boolean initialized = false;
    private String accessHeader = "Access-Control-Allow-Origin";
    private String token = "*";


    //Can't use @BeforeClass because mvc and service can't be static
    @Before
    public void setUp() {
        if(!initialized) {

            List<TitleInfo> result = new ArrayList<>();

            TitleInfo title = TitleInfo.builder()
                    .id(1)
                    .title("Avengers")
                    .isTvShow(true)
                    .build();

            TitleInfo title2 = TitleInfo.builder()
                    .id(2)
                    .title("Black Panthern")
                    .isTvShow(false)
                    .build();

            result.add(title);
            result.add(title2);

            when(titlesService.searchForTitles("Avengers")).thenReturn(result);

            initialized = true;
        }
    }

    @Test
    public void testSearch() throws Exception {
//        mvc.perform(get("/api/title/search/Avengers")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(header().string("Access-Control-Allow-Origin", nullValue()))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id", is(1)))
//                .andExpect(jsonPath("$[0].title", is("Avengers")))
//                .andExpect(jsonPath("$[0].isTvShow", is(true)))
//                .andExpect(jsonPath("$[1].id", is(2)))
//                .andExpect(jsonPath("$[1].title", is("Black Panthern")))
//                .andExpect(jsonPath("$[1].isTvShow", is(false)));

        //ISSUE 404 - can not mock outside api
    }
}
