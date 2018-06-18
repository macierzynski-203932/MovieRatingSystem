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
import pl.mrs.movie_raiting_system.dto.TitleInfo;
import pl.mrs.movie_raiting_system.dto.UserInfo;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TitlesServiceTest extends ServiceTest {
    @TestConfiguration
    static class TitlesServiceTestContextConfiguration {

        @Bean
        public TitlesService titlesService() {
            return new TitlesService();
        }
    }

    @Autowired
    private TitlesService service;

    @Before
    public void setUp() {
        init();
    }

    @Test
    public void testSearchForTitles() throws EntityNotFoundException {
        List<TitleInfo> titles = service.searchForTitles(super.query);
        assertEquals(titles.get(0).getId(), title1.getId());
        assertEquals(titles.get(0).getTitle(), title1.getTitle());
        assertEquals(titles.get(0).getIsTvShow(), title1.getIsTvShow());
        assertEquals(titles.get(1).getId(), title2.getId());
        assertEquals(titles.get(1).getTitle(), title2.getTitle());
        assertEquals(titles.get(1).getIsTvShow(), title2.getIsTvShow());
    }
}
