import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  username: string;
  password: string;
  lastName: string;
  homeTown: string;
  firstName: string;



  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }



  public registerTrainer(value:any){

    let name = this.firstName + " " + this.lastName;
    this.userService.registerNewTrainer(this.username, this.password, this.homeTown, name);
  }


}
