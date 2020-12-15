import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admission',
  templateUrl: './admission.component.html',
  styleUrls: ['./admission.component.css']
})
export class AdmissionComponent implements OnInit {

  pokemonName: string;

  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }

  public admitNewPatient(){
    
    this.userService.admitNewPokemon(0, this.pokemonName.toLocaleLowerCase());
  
  }
}
