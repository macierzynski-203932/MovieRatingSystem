import {Injectable} from "@angular/core";
import {HttpService} from "../services/http.service";
import {Configuration} from "../app.constants";
import {FavouriteMovie} from "./models/FavouriteMovie";
import {Observable} from "rxjs/Observable";

@Injectable()
export class FavouriteMoviesService {
  constructor(private httpService: HttpService,
              private configuration: Configuration) {}

  getFavouriteMovies() :Observable<FavouriteMovie[]>{
    var url = this.configuration.ServerWithApiUrl + "/movies/favourite";
    return this.httpService.get<FavouriteMovie[]>(url);
  }
}
