import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee-registration',
  templateUrl: './employee-registration.component.html',
  styleUrls: ['./employee-registration.component.css']
})
export class EmployeeRegistrationComponent implements OnInit {

  username: string;
  password: string;
  lastName: string;
  roleId: number;
  firstName: string;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  public registerEmployee(value:any){


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
    

    this.roleId = selectedRole.value;
    
    
    console.log(this.roleId)

    //console.log(`Assigned: ${this.username}, ${this.password}`);

    if(this.roleId== 1){
      console.log("Registering Nurse")
      let name = `${this.firstName} ${this.lastName}`;


      this.userService.registerNurse(name,this.username,this.password)
    }else{

      console.log("Registering an Admin!")
      let name = `${this.firstName} ${this.lastName}`;

      this.userService.registerAdmin(name,this.username,this.password)
      console.log('checking creds...')
    }


    
  }

}
