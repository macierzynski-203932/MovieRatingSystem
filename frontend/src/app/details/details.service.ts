import { Injectable } from '@angular/core';
import {SearchResponse} from '../search/models/search-response';
import {Observable} from 'rxjs/Observable';
import {HttpService} from '../services/http.service';
import {Configuration} from '../app.constants';
import {MovieDetails} from './models/movie-details';
import {TvShowDetails} from './models/tv-show-details';

@Injectable()
export class DetailsService {
  constructor(private httpService: HttpService,
              private configuration: Configuration) {}

  getMovieDetails(id: string) :Observable<MovieDetails> {
    var url = this.configuration.ServerWithApiUrl + "/details/movie/" + id;
    return this.httpService.authenticatedGet<MovieDetails>(url);
  }

  getTvShowDetails(id: string) :Observable<TvShowDetails> {
    var url = this.configuration.ServerWithApiUrl + "/details/tv/" + id;
    return this.httpService.get<TvShowDetails>(url);

  }
}
