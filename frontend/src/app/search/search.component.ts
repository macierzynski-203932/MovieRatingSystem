import { Component, OnInit } from '@angular/core';
import {SearchService} from './search.service';
import {SearchResponse} from './models/search-response';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  public titlesList: SearchResponse[];
  constructor(private searchService: SearchService) { }

  ngOnInit() {
  }

  searchSubmit(value: string) {
    this.searchService.search(value).subscribe(response => {
      this.titlesList = response;
      console.log("got it" + this.titlesList[0].title);
    });
  }

}
