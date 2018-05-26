package service;

import dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = false)
    public Long save(User user) {
        if (user.getId() == null) {
            user.setEnabled(true);
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setUsername(user.getEmail());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user).getId();
        } else {
            //user = userRepository.findOne(user.getId());
            user.setFirstName(user.getFirstName());
            user.setLastName(user.getLastName());
            user.setEmail(user.getEmail());
            if (user.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
        }
        return user.getId();
    }

    @Override
    public User get(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User get(String username) {
        return userRepository.findByDetailsUsername(username);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        User user = userRepository.getOne(id);
        userRepository.delete(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void disable(Long id) {
        User user = userRepository.getOne(id);
        if (user != null) {
            user.setEnabled(false);
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> filterSearchUsers(String searchCategory, String searchString, int sortDirection) {

        if ("".equals(searchCategory) && "".equals(searchString) && sortDirection == 0) {
            return new ArrayList<>();
        }
        List<User> users = userRepository.findAll();
        if ("nazwisko".equals(searchCategory)) {
            if (!searchString.isEmpty())
                for (int i = 0; i < users.size(); i++)
                    if (!users.get(i).getLastName().toLowerCase().contains(searchString.toLowerCase()))
                        users.remove(i--);
            Collections.sort(users, (a, b) -> a.getLastName().compareToIgnoreCase(b.getLastName()) * sortDirection);
        } else if ("email".equals(searchCategory)) {
            if (!searchString.isEmpty())
                for (int i = 0; i < users.size(); i++)
                    if (!users.get(i).getEmail().toLowerCase().contains(searchString.toLowerCase()))
                        users.remove(i--);
            Collections.sort(users, (a, b) -> a.getEmail().compareToIgnoreCase(b.getEmail()) * sortDirection);
        } else if ("imie".equals(searchCategory)) {
            if (!searchString.isEmpty())
                for (int i = 0; i < users.size(); i++)
                    if (!users.get(i).getFirstName().toLowerCase().contains(searchString.toLowerCase()))
                        users.remove(i--);
            Collections.sort(users, (a, b) -> a.getFirstName().compareToIgnoreCase(b.getFirstName()) * sortDirection);
        }
        Collections.sort(users, (a, b) -> {
            String sa = "", sb = "";
            for (int j = 0; j < users.size(); j++)
                sa += (a.getFirstName() + a.getLastName());
            for (int j = 0; j < users.size(); j++)
                sb += (b.getFirstName() + b.getLastName());
            return sa.compareToIgnoreCase(sb) * sortDirection;
        });

        return users;
    }
}
