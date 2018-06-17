import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {DetailsService} from './details.service';
import {MovieDetails} from './models/movie-details';

@Component({
  selector: 'app-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  public details: MovieDetails

  constructor(private route: ActivatedRoute,
              private detailsService: DetailsService) { }

  ngOnInit() {
    this.getDetails();
  }

  receivedDetails(details: MovieDetails) {
    this.details = details;
  }

  getDetails(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.detailsService.getMovieDetails(id).subscribe(details => this.receivedDetails(details));
  }

}
