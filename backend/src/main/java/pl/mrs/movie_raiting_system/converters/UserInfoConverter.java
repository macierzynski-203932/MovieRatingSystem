package pl.mrs.movie_raiting_system.converters;

import pl.mrs.movie_raiting_system.dto.UserInfo;
import pl.mrs.movie_raiting_system.entities.User;

public class UserInfoConverter {

    public static UserInfo getUserInfo(User user) {
        return UserInfo.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .build();
    }
}
