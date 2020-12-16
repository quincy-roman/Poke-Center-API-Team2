import { User } from './../../../../../../src/app/models/user.model';
import { DashboardService } from './../../services/dashboard.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  user : User = JSON.parse(sessionStorage.getItem("currentUser"));
  

  constructor(private dashboardService: DashboardService) { }

  ngOnInit(): void {
    console.log(sessionStorage.getItem("currentUser"));

   


  }


  

  public updateMyProfile(username: string, name: string, password: string){

    this.dashboardService.updateMyProfile(username,name,password);

  }
}
