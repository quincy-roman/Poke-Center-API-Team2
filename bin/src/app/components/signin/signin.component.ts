import { Router } from '@angular/router';
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
  username: string;
  password: string;

  title: string = "Sign In";
  
  constructor(private titleService: Title, private http: HttpClient, private authService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
    this.setTitle(this.title);
  }

  public setTitle(newTitle: string){
    this.titleService.setTitle(`PokeCenter API || ${newTitle}`);
  }

  public signinUser(value: any){
    console.log(`Assigned: ${this.username}, ${this.password}`);
    if(this.username == "aaknox" && this.password == "password"){
      console.log('checking creds...')
      this.authService.login(this.username, this.password);
    }else{
      console.log("user unauthorized");
      this.router.navigate(["../"]);
    }
  }

}
