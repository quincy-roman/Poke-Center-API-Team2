import { User } from './../../../../src/app/models/user.model';
import { DashboardService } from './../../services/dashboard.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  user : User = JSON.parse(sessionStorage.getItem("currentUser"));
  

  username: string;
  password : string;
  name: string;
  constructor(private dashboardService: DashboardService) { }

  ngOnInit(): void {
    //console.log(sessionStorage.getItem("currentUser"));

   


  }


  

  public updateProfile(value: any){
  

    const usernameTest = document.getElementById("username") as HTMLInputElement;

    const passwordTest = document.getElementById("password") as HTMLInputElement;
    const nameTest = document.getElementById("name") as HTMLInputElement;


    this.dashboardService.updateMyProfile(usernameTest.value,nameTest.value,passwordTest.value);

  }
}
