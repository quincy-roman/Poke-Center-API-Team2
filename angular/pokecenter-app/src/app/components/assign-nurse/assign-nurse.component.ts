import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-assign-nurse',
  templateUrl: './assign-nurse.component.html',
  styleUrls: ['./assign-nurse.component.css']
})
export class AssignNurseComponent implements OnInit {

  patientId:number;
  username: string;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }


  

  assignNurse(value: any){

      
  
       
    
  
      console.log(`Assigned credentials: ${this.username}, ${this.patientId}`);
  
      
  
      
    
    
    

    this.userService.assignNurse(this.patientId,this.username)
  }
}
