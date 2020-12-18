import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-treat-pokepatient',
  templateUrl: './treat-pokepatient.component.html',
  styleUrls: ['./treat-pokepatient.component.css']
})
export class TreatPokepatientComponent implements OnInit {

  medId: string;
  patientId: string;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }


  treatPatient(value :any){

    const medId = document.getElementById("medId") as HTMLInputElement;
    const patientId = document.getElementById("patientId") as HTMLInputElement;

    let medicineId = Number(medId.value)
    let patId = Number(patientId.value)
    this.userService.treatPatient(medicineId,patId);

  }
}
