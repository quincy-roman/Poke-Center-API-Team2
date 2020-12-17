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
  role: string;

  title: string = "Sign In";
  
  constructor(private titleService: Title, private http: HttpClient, private authService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
    this.setTitle(this.title);
  }

  public setTitle(newTitle: string){
    this.titleService.setTitle(`PokeCenter API || ${newTitle}`);
  }

  public signinUser(value: any){


    let selectedRole = null

     const roles = document.getElementsByName("role") as NodeListOf<HTMLInputElement>;
   // console.log(roles);
    for(var i=0; i<roles.length;i++){
      let ele = roles[i];
     // console.log(ele);
      if(ele.checked){
        selectedRole = roles[i];
        console.log(ele);
        break;
      }
    }
    

    let selectedUserType = selectedRole.value;
    
    
    console.log(selectedUserType)

    console.log(`Assigned: ${this.username}, ${this.password}`);

    if(selectedUserType== 1){
      console.log("Logging in as a trainer!")
      this.authService.loginTrainer(this.username, this.password);
    }else{

      console.log("logging in as an employee!!")
      this.authService.loginEmployee(this.username, this.password);
      console.log('checking creds...')
    }

    
  
  }

  public signInTest(value: any){



   // console.log(`Assigned: ${this.username}, ${this.password}`);
    if(this.username == "aaknox" && this.password == "password"){
      console.log('checking creds...')
    //  this.authService.login(this.username, this.password);
    this.router.navigate(['home'])
    }else{
      console.log("user unauthorized");
      this.router.navigate(["../"]);
    }
  }

}
