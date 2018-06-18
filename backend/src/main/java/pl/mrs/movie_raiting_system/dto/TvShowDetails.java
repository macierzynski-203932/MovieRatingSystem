package pl.mrs.movie_raiting_system.dto;

import lombok.*;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.Genre;
import pl.mrs.movie_raiting_system.dto.theMovieDbApi.Season;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TvShowDetails {

    private String firstAirDate;
    private String lastAirDate;
    private Genre[] genres;
    private int id;
    private boolean inProduction;
    private String name;
    private int numberOfEpisodes;
    private int numberOfSeasons;
    private String description;
    private String posterPath;
    private Double averageVote;
    private Season[] seasons;
}
