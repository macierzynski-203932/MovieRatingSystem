package pl.mrs.movie_raiting_system.dto.theMovieDbApi;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MovieDetails {

    private int id;
    private int budget;
    private Genre[] genres;
    private String overview;
    private String poster_path;
    private String release_date;
    private String title;
    private Double vote_average;
    private int vote_count;
}
