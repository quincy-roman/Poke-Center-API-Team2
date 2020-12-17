import { Router } from '@angular/router';
import { UserService } from './../../../services/user.service';
import { DashboardService } from './../../../services/dashboard.service';
import { User } from './../../../../../src/app/models/user.model';
import { TableService } from './../../../services/table.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router, private tableService: TableService, private dashboardService: DashboardService, private userService: UserService) { }

  //user : User = JSON.parse(sessionStorage.getItem("currentUser"));

 user: User =new User();
 
  

  ngOnInit(): void {



    console.log(sessionStorage.getItem("currentUser"));

    let user = JSON.parse(sessionStorage.getItem('currentUser'))

    console.log(user)

    //says if they are a nurse
    if(user.roleId==1){
      //hide admin and trainer options
      console.log("current user is a nurse")

      

      var nurseOption = document.querySelector('.NurseControls');
        console.log(nurseOption);
        nurseOption.classList.remove('hide');
	


      //says if trainer
    }else if(user.roleId == 3){
      //hide nurse and admin roles
      console.log("current user is a trainer")

      var trainerOption = document.querySelector('.TrainerControls');
        console.log(trainerOption);
        trainerOption.classList.remove('hide');
	


    }else{
      console.log("current user is an admin")


      var nurseOption = document.querySelector('.NurseControls');
      
        console.log(nurseOption);
        nurseOption.classList.remove('hide');

      
        var adminOption = document.querySelector('.AdminControls');
        console.log(adminOption);
        adminOption.classList.remove('hide');
	

        var trainerOption = document.querySelector('.TrainerControls');
        console.log(trainerOption);
        trainerOption.classList.remove('hide');
	

	

      
    }
    
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
