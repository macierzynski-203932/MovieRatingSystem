import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {SearchComponent} from '../search/search.component';
import { MovieDetailsComponent } from '../details/movie-details.component';
import { LoginComponent } from "../login/login.component";

const routes: Routes = [
  { path: '', redirectTo: '', pathMatch: 'full'},
  { path: 'search', component: SearchComponent, pathMatch: 'full' },
  { path: 'details/movie/:id', component: MovieDetailsComponent},
  { path: 'login', component: LoginComponent}
]

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
