package pl.mrs.movie_raiting_system.service;

import pl.mrs.movie_raiting_system.entities.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
