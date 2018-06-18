package pl.mrs.movie_raiting_system.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
