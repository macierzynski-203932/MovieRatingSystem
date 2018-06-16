import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SearchComponent } from './search/search.component';
import {AppRoutingModule} from './app-routing/app-routing.module';
import {Configuration} from './app.constants';
import {HttpService} from './services/http.service';
import {SearchService} from './search/search.service';
import {HttpClient, HttpClientModule, HttpHandler} from '@angular/common/http';
import {HttpErrorHandler} from './services/http-error-handler.service';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    Configuration,
    HttpService,
    SearchService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
