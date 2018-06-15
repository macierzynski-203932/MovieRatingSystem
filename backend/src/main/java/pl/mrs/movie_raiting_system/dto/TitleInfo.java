package pl.mrs.movie_raiting_system.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TitleInfo {

    private Long id;
    private Long voteCount;
    private Double averageVote;
    private String title;
    private String posterUrl;
    private String description;
    private String releaseDate;
    private Boolean isTvShow;
}
