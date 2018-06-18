package pl.mrs.movie_raiting_system.converters;

import pl.mrs.movie_raiting_system.dto.TvShowDetails;

public class TvShowDetailsConverter {

    public static TvShowDetails getDetails(pl.mrs.movie_raiting_system.dto.theMovieDbApi.TvShowDetails show) {
        return TvShowDetails.builder()
                .firstAirDate(show.getFirst_air_date())
                .lastAirDate(show.getLast_air_date())
                .genres(show.getGenres())
                .id(show.getId())
                .inProduction(show.isIn_production())
                .name(show.getName())
                .numberOfEpisodes(show.getNumber_of_episodes())
                .numberOfSeasons(show.getNumber_of_seasons())
                .description(show.getOverview())
                .posterPath(show.getPoster_path())
                .averageVote(show.getVote_average())
                .seasons(show.getSeasons())
                .build();
    }

}
