import { Router } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private router: Router) { }

  public viewMyProfile(trainerId : number){
   


    console.log("in view my profile service...")
        let xhr = new XMLHttpRequest();

        let user = sessionStorage.getItem("currentUser");
        let data = JSON.parse(user);

        

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
            sessionStorage.setItem("currentUser",xhr.responseText);
            this.router.navigateByUrl('/dashboard');
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to get profile information from server.'
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
        xhr.open("GET", "/dashboard", true);
        xhr.send(JSON.stringify(data));

  }


  public updateMyProfile(myUsername: string, myPassword: string, myName: string){
   


    console.log("in view my update proile service...")
        let xhr = new XMLHttpRequest();

       // let user = sessionStorage.getItem("currentUser");
       // let data = JSON.parse(user);

       let updateTemplate={
          username :myUsername,
          password: myPassword,
          name : myName
          
       }

        

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
    	if(xhr.readyState <= 3){
    		console.log('loading');
    	}
        if(xhr.readyState === 4 && xhr.status === 200)
        {
            console.log("Success")
            sessionStorage.setItem("currentUser",xhr.responseText);
            this.router.navigateByUrl('/dashboard');
        }
        if(xhr.readyState ===4 && xhr.status ===204)
        {
            console.log("Failed. Status Code: " + xhr.status)
			var reason = {
				code : xhr.status,
        issue : 'Failed to update profile information from server.'
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
        xhr.open("POST", "/dashboard", true);
        xhr.send(JSON.stringify(updateTemplate));

  }
}






