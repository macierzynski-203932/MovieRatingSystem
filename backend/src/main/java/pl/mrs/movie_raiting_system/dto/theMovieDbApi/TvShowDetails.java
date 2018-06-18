package pl.mrs.movie_raiting_system.dto.theMovieDbApi;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TvShowDetails {

    private String first_air_date;
    private String last_air_date;
    private Genre[] genres;
    private int id;
    private boolean in_production;
    private String name;
    private int number_of_episodes;
    private int number_of_seasons;
    private String overview;
    private String poster_path;
    private Double vote_average;
    private Season[] seasons;
}
