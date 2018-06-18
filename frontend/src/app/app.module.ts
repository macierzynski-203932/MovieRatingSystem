import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SearchComponent } from './search/search.component';
import {AppRoutingModule} from './app-routing/app-routing.module';
import {Configuration} from './app.constants';
import {HttpService} from './services/http.service';
import {SearchService} from './search/search.service';
import {HttpClient, HttpClientModule, HttpHandler, HTTP_INTERCEPTORS} from '@angular/common/http';
import {HttpErrorHandler} from './services/http-error-handler.service';
import { MovieDetailsComponent } from './details/movie-details.component';
import {DetailsService} from './details/details.service';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { AuthenticationService } from "./services/authentication.service";
import { XhrInterceptor } from './xhr-interceptor';
import { AuthGuardService } from './services/auth-guard.service';
import { RegisterComponent } from './register/register.component';
import { RegisterService } from './register/register.service';
//import { TvShowDetailsComponent } from './details/tv-show-details/tv-show-details.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SearchComponent,
    MovieDetailsComponent,
    LoginComponent,
    RegisterComponent,
   // TvShowDetailsComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    Configuration,
    HttpService,
    SearchService,
    DetailsService,
    AuthenticationService,
    RegisterService,
    AuthGuardService,
    { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
