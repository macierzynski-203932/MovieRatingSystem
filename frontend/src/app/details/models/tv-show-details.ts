import {Genre} from './genre';
//import {Season} from './season';

export class TvShowDetails {
 firstAirDate: string;
 lastAirDate: string;
 genres: Genre[];
 id: string;
 inProduction: boolean;
 name: string;
 numberOfEpisodes: string;
 numberOfSeasons: string;
 overview: string;
 posterPath: string;
 averageVote: string;
// seasons: Season[];
}
