import { API_URL } from 'src/environments/environment.prod';
import { Router } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class DashboardService {

    constructor(private router: Router) { }

    public viewMyProfile(trainerId: number) {



        console.log("in view my profile service...")
        let xhr = new XMLHttpRequest();

        let user = sessionStorage.getItem("currentUser");
        let data = JSON.parse(user);



        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem("currentUser", xhr.responseText);
                this.router.navigateByUrl('/trainer/profile');
            }
            if (xhr.readyState === 4 && xhr.status === 204) {
                console.log("Failed. Status Code: " + xhr.status)
                var reason = {
                    code: xhr.status,
                    issue: 'Failed to get profile information from server.'
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
        xhr.open("POST", `${API_URL}trainer/profile`, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(data));

    }


    public updateMyProfile(myUsername: string, myName: string, myPassword: string) {



        console.log("in view my update proile service...")
        let xhr = new XMLHttpRequest();
        let user = JSON.parse(sessionStorage.getItem("currentUser"))

        // let user = sessionStorage.getItem("currentUser");
        // let data = JSON.parse(user);

        console.log(user)
        let trainerTemplate = {
            trainerId: user.trainerid,
            trainerName: myName,
            hometown: user.hometown,
            username: myUsername,
            password: myPassword

        }
        console.log(trainerTemplate)



        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem("currentUser", xhr.responseText);
                this.router.navigateByUrl('/home');
            }
            if (xhr.readyState === 4 && xhr.status === 204) {
                console.log("Failed. Status Code: " + xhr.status)
                var reason = {
                    code: xhr.status,
                    issue: 'Failed to update profile information from server.'
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
        xhr.open("PUT", `${API_URL}trainer/update`, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        console.log(trainerTemplate)
        xhr.send(JSON.stringify(trainerTemplate));

    }
}






