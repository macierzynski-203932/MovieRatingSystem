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

import javax.persistence.EntityNotFoundException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserServiceTest extends ServiceTest{
//    @TestConfiguration
//    static class UserServiceTestContextConfiguration {
//
//        @Bean
//        public UserService userService() {
//            return new UserService();
//        }
//    }
//
//    @Rule
//    public ExpectedException expectedException = ExpectedException.none();
//
//    @Autowired
//    private UserService service;
//
//    @Before
//    public void setUp() {
//        init();
//    }
//
//    @Test
//    public void testGetUserInfo() throws EntityNotFoundException {
//        UserInfo user = service.getUserInfo(user1.getId());
//        assertEquals(user.getId(), user1.getId());
//        assertEquals(user.getEmail(), user1.getEmail());
//        assertEquals(user.getName(), user1.getName());
//        assertEquals(user.getSurname(), user1.getSurname());
//    }
}
