import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {DetailsService} from './details.service';
import {MovieDetails} from './models/movie-details';
import {Location} from '@angular/common';


@Component({
  selector: 'app-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  public details: MovieDetails

  constructor(private route: ActivatedRoute,
              private detailsService: DetailsService,
              private location: Location) { }

  ngOnInit() {
    this.getDetails();
  }

  getDetails(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.detailsService.getMovieDetails(id).subscribe(details => this.details = details);
  }

  addMovie(): void {
    this.detailsService.addMovieToFavourite(this.details).subscribe(details => this.lol());
  }

  lol(): void{
    console.log("cokolwiek");
  }

}
