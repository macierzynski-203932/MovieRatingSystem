import { Component, OnInit } from '@angular/core';
import {SearchService} from './search.service';
import {SearchResponse} from './models/search-response';
import {Router} from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  public titlesList: SearchResponse[];
  constructor(private searchService: SearchService,
              private router: Router) { }

  ngOnInit() {
  }

  searchSubmit(value: string) {
    this.searchService.search(value).subscribe(response => {
      this.titlesList = response;
    });
  }

  goToDetails(title: SearchResponse) {
      this.router.navigateByUrl('/details/movie/' + title.id);
  }

}
