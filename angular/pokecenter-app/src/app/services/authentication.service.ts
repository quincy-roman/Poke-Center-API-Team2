import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { User } from '../models/user.model';
import { API_URL } from './../../environments/environment.prod';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  //properties
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  //constructor
  constructor(private http: HttpClient) { }

  //CRUD method(s)
  //sendUserDetails to server for authentication
  getUserDetails(username: string, password: string) {
    //post these details to API server
    //return user info if correct
    return this.http
      .post<User>(`${API_URL}sigin`, {'username': username, 'password': password}, this.httpOptions)
      .pipe(
        catchError(this.handleError<any>('cannot sign in user'))
      )
  }

  //error handling methods
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
