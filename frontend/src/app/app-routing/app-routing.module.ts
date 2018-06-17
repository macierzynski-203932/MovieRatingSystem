import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {SearchComponent} from '../search/search.component';
import {MovieDetailsComponent} from '../details/movie-details.component';
import {FavouriteMoviesComponent} from "../favourite-movies/favourite-movies.component";

const routes: Routes = [
  { path: '', redirectTo: '', pathMatch: 'full'},
  { path: 'search', component: SearchComponent, pathMatch: 'full' },
  { path: 'details/movie/:id', component: MovieDetailsComponent},
  { path: 'FavouriteMovies', component: FavouriteMoviesComponent}
]

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
