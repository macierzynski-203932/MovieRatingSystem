import { Component, OnInit } from '@angular/core';
import {MovieDetails} from '../models/movie-details';
import {ActivatedRoute} from '@angular/router';
import {DetailsService} from '../details.service';
import {TvShowDetails} from '../models/tv-show-details';

@Component({
  selector: 'app-tv-show-details',
  templateUrl: './tv-show-details.component.html',
  styleUrls: ['./tv-show-details.component.css']
})
export class TvShowDetailsComponent implements OnInit {

  public details: TvShowDetails;
  public selectedSeason: string = '0';
  public selectedEpisode: string = '0';

  constructor(private route: ActivatedRoute,
              private detailsService: DetailsService) { }

  ngOnInit() {
    this.getDetails();
  }

  receivedDetails(details: TvShowDetails) {
    this.details = details;
  }

  getDetails(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.detailsService.getTvShowDetails(id).subscribe(details => this.receivedDetails(details));
  }


}
