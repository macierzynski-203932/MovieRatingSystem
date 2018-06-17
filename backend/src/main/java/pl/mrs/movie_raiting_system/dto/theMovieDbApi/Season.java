package pl.mrs.movie_raiting_system.dto.theMovieDbApi;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Season {

    private int id;
    private int season_number;
    private int episode_count;
    private EpisodeDetails[] episodes;
}
