import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent
} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomInterceptorService implements HttpInterceptor{

  constructor() { }

  // Intercepttors allow us to intercept incoming or outgoing HTTP requests using the HTTPClient.  By
  // intercepting the request , we can modify or change the value of the request

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log("Intercepting");

    request = request.clone({
      withCredentials: true
    });

    return next.handle(request);
  }
}
