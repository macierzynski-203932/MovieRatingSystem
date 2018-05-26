package service;

import dao.User;

import java.util.List;

public interface UserService {
    Long save(User user);

    User get(Long id);

    User get(String username);

    void update(User user);

    void delete(Long id);

    void disable(Long id);

    List<User> findAll();

    public List<User> filterSearchUsers(String searchCategory, String searchString, int sortDirection);
}
