package pl.mrs.movie_raiting_system.dto.theMovieDbApi;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class EpisodeDetails {
    private String air_date;
    private int episode_number;
    private String name;
    private String overview;
    private String id;
    private int season_number;
    private double vote_average;
}
