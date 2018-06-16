package pl.mrs.movie_raiting_system.dto.theMovieDbApi;

import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public abstract class TitleList {

    private int page;
    private int total_results;
    private int total_pages;
}
