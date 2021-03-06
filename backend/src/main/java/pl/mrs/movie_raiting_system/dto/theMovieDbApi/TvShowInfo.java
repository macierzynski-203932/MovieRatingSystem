package pl.mrs.movie_raiting_system.dto.theMovieDbApi;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TvShowInfo {

    private int id;
    private String name;
    private String poster_path;
}
