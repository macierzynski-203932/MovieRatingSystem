import { NgModule }             from '@angular/core';
import { RouterModule, Routes, CanActivate } from '@angular/router';

import {SearchComponent} from '../search/search.component';
import { MovieDetailsComponent } from '../details/movie-details.component';
import { LoginComponent } from "../login/login.component";
import { RegisterComponent } from '../register/register.component';
import { AuthGuardService as AuthGuard } from '../services/auth-guard.service';
import {MovieDetailsComponent} from '../details/movie-details.component';
import {TvShowDetailsComponent} from '../details/tv-show-details/tv-show-details.component';

const routes: Routes = [
  { path: '', redirectTo: '', pathMatch: 'full'},
  { path: 'search', component: SearchComponent, pathMatch: 'full', canActivate: [AuthGuard] },
  { path: 'details/movie/:id', component: MovieDetailsComponent, canActivate: [AuthGuard]},
  { path: 'details/tv/:id', component: TvShowDetailsComponent, canActivate: [AuthGuard]},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent}

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
