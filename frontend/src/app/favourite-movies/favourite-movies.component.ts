import { Component, OnInit } from '@angular/core';
import {FavouriteMovie} from "./models/FavouriteMovie";
import {FavouriteMoviesService} from "./favourite-movies.service";

@Component({
  selector: 'app-favourite-movies',
  templateUrl: './favourite-movies.component.html',
  styleUrls: ['./favourite-movies.component.css']
})
export class FavouriteMoviesComponent implements OnInit {

  public favouriteMovies: FavouriteMovie[];

  constructor(  private favouriteMoviesService: FavouriteMoviesService) { }

  ngOnInit() {
    this.getFavouriteMovies();
  }

  getFavouriteMovies(): void{
    this.favouriteMoviesService.getFavouriteMovies().subscribe(favouriteMovies => this.favouriteMovies = favouriteMovies);
  }

}
