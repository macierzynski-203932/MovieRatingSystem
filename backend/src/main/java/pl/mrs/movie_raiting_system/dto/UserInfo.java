package pl.mrs.movie_raiting_system.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserInfo {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
}
