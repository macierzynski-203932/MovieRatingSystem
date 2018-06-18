package pl.mrs.movie_raiting_system.service;

import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.mrs.movie_raiting_system.dao.UserRepository;
import pl.mrs.movie_raiting_system.dto.TitleInfo;
import pl.mrs.movie_raiting_system.dto.UserInfo;
import pl.mrs.movie_raiting_system.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceTest
{
    @MockBean
    private UserRepository userRepository;

    @MockBean
    private TitlesService titlesService;

    boolean initialized;

    protected UserInfo user1;
    protected User mainUser;
    protected TitleInfo title1, title2;
    protected List<TitleInfo> titles;

    protected String query = "Avengers";

    protected void init() {
        if (!initialized) {

            user1 = UserInfo.builder()
                    .id(1L)
                    .name("Kamil")
                    .surname("Niemczycki")
                    .email("niemczycki@wp.pl")
                    .build();

            mainUser = User.builder()
                    .id(1L)
                    .name("Kamil")
                    .surname("Niemczycki")
                    .email("niemczycki@wp.pl")
                    .build();

            title1 = TitleInfo.builder()
                    .id(1)
                    .title("Avengers")
                    .isTvShow(false)
                    .build();

            title2 = TitleInfo.builder()
                    .id(2)
                    .title("Black panthern")
                    .isTvShow(true)
                    .build();

            titles = new ArrayList(){
                {
                    add(title1);
                    add(title2);
                }
            };
            Mockito.when(userRepository.findById(Long.valueOf(user1.getId())))
                    .thenReturn(Optional.of(mainUser));

            Mockito.when(titlesService.searchForTitles(query))
                    .thenReturn(titles);
            initialized = true;
        }
    }
}
