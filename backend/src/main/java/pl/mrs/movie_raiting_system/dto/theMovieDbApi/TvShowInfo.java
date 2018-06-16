package pl.mrs.movie_raiting_system.dto.theMovieDbApi;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TvShowInfo {

    private Long id;
    private Long vote_count;
    private Double vote_average;
    private String name;
    private String poster_path;
    private String overview;
    private String first_air_date;
}
