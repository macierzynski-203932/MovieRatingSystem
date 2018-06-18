package pl.mrs.movie_raiting_system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mrs.movie_raiting_system.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findById(Long id);
    User findByUsername (String login);
}
