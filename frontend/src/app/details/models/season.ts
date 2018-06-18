import {Episode} from './episode';

export class Season {
  id: string;
  season_number: string;
  episode_count: string;
  episodes: Episode[];
}
