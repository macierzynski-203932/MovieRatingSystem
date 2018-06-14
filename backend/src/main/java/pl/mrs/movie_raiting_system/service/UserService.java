package pl.mrs.movie_raiting_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mrs.movie_raiting_system.converters.UserInfoConverter;
import pl.mrs.movie_raiting_system.dao.UserRepository;
import pl.mrs.movie_raiting_system.dto.UserInfo;
import pl.mrs.movie_raiting_system.entities.User;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserInfo getUserInfo(Long id) throws EntityNotFoundException{
        Optional<User> userQuery = userRepository.findById(id);

        if(!userQuery.isPresent()) {
            throw new EntityNotFoundException("User does not exist");
        }
        return UserInfoConverter.getUserInfo(userQuery.get());
    }
}
