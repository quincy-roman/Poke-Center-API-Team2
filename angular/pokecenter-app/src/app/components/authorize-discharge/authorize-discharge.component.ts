import { Component, OnInit } from '@angular/core';
import { UserService } from './../../services/user.service';

@Component({
  selector: 'app-authorize-discharge',
  templateUrl: './authorize-discharge.component.html',
  styleUrls: ['./authorize-discharge.component.css']
})
export class AuthorizeDischargeComponent implements OnInit {

  patientId: string;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }



  authorizePatientDischarge(value :any){

    const patientId = document.getElementById("patientId") as HTMLInputElement;

    let patId = Number(patientId.value)
    this.userService.authorizeDischarge(patId);

  }
}
