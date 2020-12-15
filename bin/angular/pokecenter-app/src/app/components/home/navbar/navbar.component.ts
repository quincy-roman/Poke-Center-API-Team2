import { UserService } from './../../../services/user.service';
import { DashboardService } from './../../../services/dashboard.service';
import { User } from './../../../../../../../src/app/models/user.model';
import { TableService } from './../../../services/table.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private tableService: TableService, private dashboardService: DashboardService, private userService: UserService) { }

  //user : User = JSON.parse(sessionStorage.getItem("currentUser"));

 user: User =new User();
  

  ngOnInit(): void {

    this.user.id = 0;
    this.user.name = "Azhya"
    this.user.username = "aaknox";
    this.user.password = "password"
    this.user.token = "string"

    sessionStorage.setItem("currentUser", JSON.stringify(this.user));

    console.log(sessionStorage.getItem("currentUser"));
    
  }

  public viewMyPokemon(){

      this.tableService.viewMyPokemon(this.user.id);
  }

  public viewMyPokemonStats(){

    this.tableService.viewMyPokemonStatus(this.user.id);
}

public viewMyPokemonPatients(){

  this.tableService.viewMyPokePatients(this.user.id);
}

public viewPastPokePatients(){
  this.tableService.viewPastPokePatients(this.user.id);
}

public viewMyPokePatientsCharts(){
  this.tableService.viewMyPokePatientCharts(this.user.id);
}

public getPokeTreatmentByPatientId(){
  this.tableService.getPokeTreatmentByPatientId(this.user.id);
}

public viewAllAdmittedPatients(){
  this.tableService.viewAllAdmittedPatients();
}

public viewAllPastPokePatients(){
  this.tableService.viewAllPastPokePatients();
}

public viewPokeCenterBilling(){
  this.tableService.viewPokeCenterBilling();
}

public viewCurrentMedicationStock(){
  this.tableService.viewCurrentMedicationStock();
}

public viewAllUsers(){
  this.tableService.viewAllUsers();
}
public viewMyProfile(){
  this.dashboardService.viewMyProfile(this.user.id);
}







}
