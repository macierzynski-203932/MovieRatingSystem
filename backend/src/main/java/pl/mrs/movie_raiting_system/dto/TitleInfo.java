package pl.mrs.movie_raiting_system.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TitleInfo {

    private int id;
    private String title;
    private String posterUrl;
    private Boolean isTvShow;
}
