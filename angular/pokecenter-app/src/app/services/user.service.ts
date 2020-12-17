import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { API_URL } from 'src/environments/environment.prod';

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

        let ability = pokemon.abilities[0].ability.name;
        console.log(ability)

        let type = pokemon.types[0].type.name;
        console.log(type)
        let type2;

        if(pokemon.types.length>1){
          type2 = pokemon.types[1].type.name;
        }else{
          console.log("no second type exists")
          type2=''
        }
        
        console.log(type2);
        //generates a current hp
        let currHp = Math.floor(Math.random() * maxHp);
        console.log("currHP= " + currHp);


        const ColorRed = 0;
        const status0 = "fainted";

        //get the Random Pokemon status unless currentHP is 0
        const status = [
          1,
          2,
          3
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

        /*
        Patient [
pateintid=0, 
pokemon=null, 
trainer=null, 
admission=null, currentHP=0, maxHP=0, 
status=null, 
nurseid=null, 
med=null, 
healthy=false, release=null]*/
        //Getting ready to send new pokemon patient to backend 
        let xhr1 = new XMLHttpRequest();
        let pokemonData = {
          dexid: pokeID,
          name: pokemonName,
          currenthp: currHp,
          maxhp: maxHp,
          statusid: pokeStatus
        }
        console.log(pokemonData);
        //sends new patient to backend

        let user = JSON.parse(sessionStorage.getItem("currentUser"))
        

        console.log(user.trainerid)
        console.log(user)


        let patientData = {
          pokemon : [{
            dexid: pokeID,
            name: pokemonName,
            type1: type,
            type2: type2,
            ability: ability
          }],

          patient: [{
            pateintid: 0, 
            pokemonDexId: pokemonData.dexid,
            trainersId: user.trainerid,
            admission: "", 
            release:"",
            currentHP: pokemonData.currenthp, 
            maxHP: pokemonData.maxhp, 
            statusId: pokemonData.statusid, 
            medId: 0, 
            healthy:false, 

          }]


        }
        console.log(patientData)

        xhr1.onreadystatechange = () => {
          console.log('ReadyState: ' + xhr1.readyState);
          if (xhr1.readyState <= 3) {
            console.log('loading');
          }
          if (xhr1.readyState === 4 && xhr1.status === 200) {
            console.log("Successfully sent new patient")
          //  sessionStorage.setItem('newPatient', xhr1.responseText);

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
        xhr1.open("POST",`${API_URL}trainer/admission`, true);
        xhr1.setRequestHeader("Content-Type", "application/json");
        xhr1.send(JSON.stringify(patientData));


      }


      this.router.navigateByUrl('/trainer/admission');
    
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



  public registerNewTrainer(myUsername: string, myPassword: string, myName: string, myHometown: string){

    console.log("in register Trainer service...")
        let xhr = new XMLHttpRequest();

      
        let trainerTemplate = {
          username: myUsername,
          password : myPassword,
          hometown: myHometown,
          trainerName: myName
        }
        

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
           // sessionStorage.setItem('tableData', xhr.responseText);
            this.router.navigateByUrl('signin')
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to register user.'
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
        xhr.open("POST", `${API_URL}trainer/registration`, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(trainerTemplate));



  }
//         (employee_name, employee_password, role_roleid, employee_username, employee_id) values (?, ?, ?, ?, ?)

  public registerNurse(myName: string,myPassword: string, myUsername: string){

    console.log("in register Employee service...")
        let xhr = new XMLHttpRequest();

        let roleTemplate={
          roleid : 1,
          role : "Nurse"
        }
      

        let employeeTemplate = {
          employeeName: myName,
          password : myPassword,
          username: myUsername,
          role: roleTemplate
        }
        
        console.log(employeeTemplate)


        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
           // sessionStorage.setItem('tableData', xhr.responseText);
            this.router.navigateByUrl('signin')
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to register user.'
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
        xhr.open("POST", `${API_URL}nurse/registration`, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(employeeTemplate));



  }
  public registerAdmin(myName: string,myPassword: string, myUsername: string){

    console.log("in register Admin service...")
        let xhr = new XMLHttpRequest();

        let roleTemplate={
          roleid : 2,
          role : "Admin"
        }
      

        let employeeTemplate = {
          employeeName: myName,
          password : myPassword,
          username: myUsername,
          role: roleTemplate
        }

        console.log(employeeTemplate)
        

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
           // sessionStorage.setItem('tableData', xhr.responseText);
            this.router.navigateByUrl('signin')
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to register user.'
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
        xhr.open("POST", `${API_URL}admin/registration`, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(employeeTemplate));



  }


  



}
