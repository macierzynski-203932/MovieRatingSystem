import { TestBed, inject } from '@angular/core/testing';

import {FavouriteMoviesService} from "./favourite-movies.service";

describe('FavouriteMoviesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FavouriteMoviesService]
    });
  });

  it('should be created', inject([FavouriteMoviesService], (service: FavouriteMoviesService) => {
    expect(service).toBeTruthy();
  }));
});
