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
import pl.mrs.movie_raiting_system.dto.UserInfo;
import pl.mrs.movie_raiting_system.service.UserService;
import pl.mrs.movie_raiting_system.service.UserService2;
import pl.mrs.movie_raiting_system.service.UserServiceImpl;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserRest.class)
@EnableSpringDataWebSupport
@WithMockUser
public class UserRestTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService2 userService;

    @MockBean
    private UserService service;

    private boolean initialized = false;

    //Can't use @BeforeClass because mvc and service can't be static
    @Before
    public void setUp() {
        if(!initialized) {
            UserInfo user = UserInfo.builder()
                    .id(1L)
                    .name("Witold")
                    .surname("Kowalski")
                    .email("kowalski@edu.lodz.pl")
                    .build();

            given(userService.getUserInfo(1L)).willReturn(user);

            initialized = true;
        }
    }

    @Test
    public void testGetUserInfo() throws Exception {
        mvc.perform(get("/api/user/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Witold")))
                .andExpect(jsonPath("$.surname", is("Kowalski")))
                .andExpect(jsonPath("$.email", is("kowalski@edu.lodz.pl")));
    }
}
