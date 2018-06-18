package pl.mrs.movie_raiting_system.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class FavouriteMovieInfo {

    private int id;
    private int budget;
    private String overview;
    private String poster_path;
    private String release_date;
    private String title;
    private Double vote_average;
    private int vote_count;
}
