import { Router } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  myPokemon: any = "";

  constructor(private router: Router) { }


  admitNewPokemon(myUserId: number, myPokemonName: string) {
    let patientTemplate = {
      userId: myUserId,
      pokemonName: myPokemonName,

    }

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = () => {
      console.log('ReadyState: ' + xhr.readyState);
      if (xhr.readyState <= 3) {
        console.log('loading');
      }
      if (xhr.readyState === 4 && xhr.status === 200) {
        console.log("Success")

        sessionStorage.setItem('tableData', xhr.responseText);

        //gets pokemon from api
        this.myPokemon = xhr.responseText;
        console.log(this.myPokemon);

        //parses as JSON objcet
        let pokemon = JSON.parse(this.myPokemon);

        //gets pokemon name
        let pokemonName = pokemon.name;
        console.log(pokemon.name);
        //gets max hp
        let maxHp = pokemon.stats[1].base_stat;
        console.log(maxHp)
        //gets id
        console.log("id: " + pokemon.id);
        let pokeID = pokemon.id;

        //generates a current hp
        let currHp = Math.floor(Math.random() * maxHp);
        console.log("currHP= " + currHp);


        const ColorRed = 0;
        const status0 = "fainted";

        //get the Random Pokemon status unless currentHP is 0
        const status = [
          "burn",
          "freeze",
           "fainted"
        ]
       // enum Status { status1, status2, status3 }

        let pokeStatus;

        if (currHp == 0) {
          pokeStatus = status[2];
        } else {

          let random = Math.floor(Math.random() * Object.keys(status).length);
          if (random % 2 == 0) {
            pokeStatus = status[1];
          } else {
            pokeStatus = status[0];
          }
        }

        //Getting ready to send new pokemon patient to backend 
        let xhr1 = new XMLHttpRequest();
        let newPatient = {
          dexid: pokeID,
          currenthp: currHp,
          maxhp: maxHp,
          name: pokemonName,
          status_name: pokeStatus
        }
        console.log(newPatient);
        //sends new patient to backend

        xhr1.onreadystatechange = () => {
          console.log('ReadyState: ' + xhr1.readyState);
          if (xhr1.readyState <= 3) {
            console.log('loading');
          }
          if (xhr1.readyState === 4 && xhr1.status === 200) {
            console.log("Successfully sent new patient")
            sessionStorage.setItem('newPatient', xhr1.responseText);

          }
          if (xhr1.readyState === 4 && xhr1.status === 204) {
            console.log("Failed. Status Code: " + xhr1.status)
            var reason = {
              code: xhr1.status,
              issue: 'Failed to send new patient data to backend.'
              //redirect to error page
            };
            console.log(reason);
            sessionStorage.setItem('failMessage', JSON.stringify(reason));
            console.log(sessionStorage.getItem('failMessage'));
            //goes to error interceptor
            alert('BAD MOJO!')
          }
          console.log("Processing")
        };
        xhr1.open("POST", "/admission/sendNewPatient", true);
        xhr1.send();


      }


      this.router.navigateByUrl('/admission');
    
    if (xhr.readyState === 4 && xhr.status === 204) {
      console.log("Failed. Status Code: " + xhr.status)
      var reason = {
        code: xhr.status,
        issue: 'Failed to load table data from server.'
        //redirect to error page
      };
      console.log(reason);
      sessionStorage.setItem('failMessage', JSON.stringify(reason));
      console.log(sessionStorage.getItem('failMessage'));
      //goes to error interceptor
      alert('BAD MOJO!')
    }
    console.log("Processing")
  };
  xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${myPokemonName}`, true);
xhr.send();



  }



}
