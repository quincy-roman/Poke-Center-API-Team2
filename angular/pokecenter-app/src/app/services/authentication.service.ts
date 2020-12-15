import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Signin } from './../models/signin.model';
import { User } from '../models/user.model';
import { API_URL } from './../../environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;
    readyState: number;

    constructor(private http: HttpClient, private router: Router) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

    login(username: string, password: string) {
        console.log("in login with service...")
        let xhr = new XMLHttpRequest();
        let loginTemplate = {
            username: username,
            password: password
        };

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
            sessionStorage.setItem('currentUser', xhr.responseText);
            this.router.navigateByUrl('home');
        }
        if(this.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
				issue : 'Failed to log in. Incorrect Username or Password.'
			};
			console.log(reason);
			sessionStorage.setItem('failMessage', JSON.stringify(reason));
            console.log(sessionStorage.getItem('failMessage'));
            //goes to error interceptor
            alert('BAD MOJO!')
        }
        console.log("Processing")
        };
        xhr.open("POST", "/signin/autheticate");
        xhr.send(JSON.stringify(loginTemplate));
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
    }
}
