import {Injectable} from '@angular/core';
import {HttpErrorResponse} from '@angular/common/http';

import {ErrorObservable} from 'rxjs/observable/ErrorObservable';
import {Router} from '@angular/router';

@Injectable()
export class HttpErrorHandler {

  private badRequest = 400;
  private notAuthorizedUserErrorCode = 401;
  private forbiddenErrorCode = 403;
  private internalErrorCode = 500;

  constructor(private router: Router) {
  }

  handleError(error: HttpErrorResponse): ErrorObservable {

    return new ErrorObservable(
      'Something went wrong. Please try again later.');
  }
}
