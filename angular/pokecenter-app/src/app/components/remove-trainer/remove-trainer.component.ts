import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-remove-trainer',
  templateUrl: './remove-trainer.component.html',
  styleUrls: ['./remove-trainer.component.css']
})
export class RemoveTrainerComponent implements OnInit {

  trainerId: number;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }


  removeTrainer(value: any){
    const trainId = document.getElementById("trainerId") as HTMLInputElement;
    let patId = Number(trainId.value)

this.userService.removePatient(patId);
  }
}
