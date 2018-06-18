import { Injectable } from '@angular/core';
import {HttpService} from '../services/http.service';
import {Observable} from 'rxjs/Observable';
import {SearchResponse} from './models/search-response';
import {Configuration} from '../app.constants';

@Injectable()
export class SearchService {

  constructor(private httpService: HttpService,
              private configuration: Configuration) {}

  search(query: string) :Observable<SearchResponse[]> {
    var url = this.configuration.ServerWithApiUrl + "/title/search?query=" + query;
    return this.httpService.authenticatedGet<SearchResponse[]>(url);
  }

}
