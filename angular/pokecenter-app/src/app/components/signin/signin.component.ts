import { AuthenticationService } from './../../services/authentication.service';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { HttpClient } from '@angular/common/http';
import { API_URL } from 'src/environments/environment.prod';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  title: string = "Sign In";
  
  constructor(private titleService: Title, private http: HttpClient, private authService: AuthenticationService) { }

  ngOnInit(): void {
    this.setTitle(this.title);
  }

  public setTitle(newTitle: string){
    this.titleService.setTitle(`PokeCenter API || ${newTitle}`);
  }

  public signinUser(value: any){
    console.log("logging in user...");
    console.log(value);
    //subscribe to auth service
    //result: set currentUser localStorage item
    //change route to home component
  }

}
