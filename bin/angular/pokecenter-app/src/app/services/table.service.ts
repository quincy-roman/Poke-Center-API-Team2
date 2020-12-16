import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TableService {

  constructor(private http: HttpClient, private router: Router) { }




  public viewMyPokemon(trainerId : number){

    console.log("in view my pokemon service...")
        let xhr = new XMLHttpRequest();
        let trainerIdTemplate = {
           trainerId: trainerId
        };

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
            sessionStorage.setItem('tableData', xhr.responseText);
            this.router.navigateByUrl('table/view-my-pokemon');
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to load table data from server.'
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
        xhr.open("GET", "/table/view-my-pokemon", true);
        xhr.send(JSON.stringify(trainerIdTemplate));

  }

  public viewMyPokemonStatus(trainerId : number){

    console.log("in view my pokemon status service...")
        let xhr = new XMLHttpRequest();
        

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
            sessionStorage.setItem('tableData', xhr.responseText);
            this.router.navigateByUrl('table/view-my-status');
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to load table data from server.'
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
        xhr.open("GET", `/table/view-my-pokemon-status?${trainerId}`, true);
        xhr.send();



  }

  public viewMyPokePatients(nurseId : number){

    console.log("in view my pokemon patients service...")
        let xhr = new XMLHttpRequest();
        

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
            sessionStorage.setItem('tableData', xhr.responseText);
            this.router.navigateByUrl('table/view-my-pokepatients');
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to load table data from server.'
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
        xhr.open("GET", `/table/view-my-pokepatients?${nurseId}`, true);
        xhr.send();


  }

  public viewPastPokePatients(nurseId : number){

    console.log("in view my past pokemon patients service...")
        let xhr = new XMLHttpRequest();
        

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
            sessionStorage.setItem('tableData', xhr.responseText);
            this.router.navigateByUrl('table/view-past-pokepatients');
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to load table data from server.'
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
        xhr.open("GET", `/table/view-past-pokepatients?${nurseId}`, true);
        xhr.send();


  }

  public viewMyPokePatientCharts(nurseId : number){

    console.log("in view my pokemon patient chart service...")
        let xhr = new XMLHttpRequest();
        

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
            sessionStorage.setItem('tableData', xhr.responseText);
            this.router.navigateByUrl('table/view-my-pokepatient-charts');
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to load table data from server.'
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
        xhr.open("GET", `table/view-my-pokepatient-charts?${nurseId}`, true);
        xhr.send();



  }

  public getPokeTreatmentByPatientId(patientId : number){

    console.log("in view my pokemon treatment by patient id service...")
        let xhr = new XMLHttpRequest();
        

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
            sessionStorage.setItem('tableData', xhr.responseText);
            this.router.navigateByUrl('table/get-poketreatment-by-patient-id');
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to load table data from server.'
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
        xhr.open("GET", `table/get-poketreatment-by-patient-id?${patientId}`, true);
        xhr.send();



  }

  

  public viewAllAdmittedPatients(){

    console.log("in view my all patients service...")
        let xhr = new XMLHttpRequest();

      
        

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
            sessionStorage.setItem('tableData', xhr.responseText);
            this.router.navigateByUrl('table/view-all-admitted-pokepatients');
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to load table data from server.'
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
        xhr.open("GET", "table/view-all-admitted-pokepatients", true);
        xhr.send();



  }

  public viewAllPastPokePatients(){

    console.log("in view all past patients service...")
        let xhr = new XMLHttpRequest();

      
        

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
            sessionStorage.setItem('tableData', xhr.responseText);
            this.router.navigateByUrl('table/view-all-past-pokepatients');
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to load table data from server.'
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
        xhr.open("GET", "table/view-all-past-pokepatients", true);
        xhr.send();



  }


  public viewPokeCenterBilling(){

    console.log("in view all billing service...")
        let xhr = new XMLHttpRequest();

      
        

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
            sessionStorage.setItem('tableData', xhr.responseText);
            this.router.navigateByUrl('table/view-billing');
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to load table data from server.'
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
        xhr.open("GET", "table/view-billing", true);
        xhr.send();



  }

  public viewCurrentMedicationStock(){

    console.log("in view medicine stock service...")
        let xhr = new XMLHttpRequest();

      
        

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
            sessionStorage.setItem('tableData', xhr.responseText);
            this.router.navigateByUrl('table/view-current-med-stock');
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to load table data from server.'
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
        xhr.open("GET", "table/view-current-med-stock", true);
        xhr.send();



  }

  public viewAllUsers(){

    console.log("in view all users service...")
        let xhr = new XMLHttpRequest();

      
        

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
            sessionStorage.setItem('tableData', xhr.responseText);
            this.router.navigateByUrl('table/view-all-users');
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to load table data from server.'
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
        xhr.open("POST", "table/view-all-users", true);
        xhr.send();



  }





  


}
