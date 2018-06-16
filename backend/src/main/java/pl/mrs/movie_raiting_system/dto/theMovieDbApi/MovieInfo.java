package pl.mrs.movie_raiting_system.dto.theMovieDbApi;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MovieInfo {

    private Long id;
    private Long vote_count;
    private Double vote_average;
    private String title;
    private String poster_path;
    private String overview;
    private String release_date;
}
