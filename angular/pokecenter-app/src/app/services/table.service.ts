import { API_URL } from 'src/environments/environment.prod';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class TableService {

    constructor(private http: HttpClient, private router: Router) { }




    public viewMyPokemon(trainerId: number) {

        let user = JSON.parse(sessionStorage.getItem('currentUser'))
        console.log("now starting ajax request")
        console.log(user)
        console.log(user.trainerid)

        console.log("in view my pokemon service...")
        let xhr = new XMLHttpRequest();
        let trainer= {
            trainerId : user.trainerid,
            trainerName : user.name,
            hometown : user.hometown,
            username: user.username,
            password: user.password

        }

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Successfully retrieved data from server")
                sessionStorage.setItem('tableData', xhr.responseText);
                const table: HTMLTableElement = <HTMLTableElement>document.getElementById('table-data');
                let dataString = sessionStorage.getItem('tableData');

                console.log(dataString);
                if (dataString != null) {
                    console.log(dataString);
                    let data = JSON.parse(dataString);
                    console.log(data);

                    if (data != null) {
                        table.innerHTML = "";
                        // load data into table
                        data.forEach(d => {
                            let row = table.insertRow();

                            let pokemonDexId = row.insertCell(0);
                            let trainersId = row.insertCell(1);
                            let admission = row.insertCell(2);
                            let release = row.insertCell(3);
                            let currentHP = row.insertCell(4);
                            let maxHP = row.insertCell(5);
                            let statusId = row.insertCell(6);
                            let medId = row.insertCell(7);
                            let healthy = row.insertCell(8);

                            pokemonDexId.innerHTML = d.pokemonDexId;
                            trainersId.innerHTML = d.trainersId;
                            admission.innerHTML = d.admission;
                            release.innerHTML = d.release;
                            currentHP.innerHTML = d.currentHP;
                            maxHP.innerHTML = d.maxHP;
                            statusId.innerHTML = d.statusId;
                            medId.innerHTML = d.statusId;
                            healthy.innerHTML = d.healthy;
                        })
                    }
                    
                }
                this.router.navigateByUrl('trainer/table/view-my-pokemon')


            }if (xhr.readyState === 4 && xhr.status > 200) {
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
                    this.router.navigateByUrl('home')

                }
                console.log("Processing")
            }
            
            xhr.open("POST", `${API_URL}trainer/table/view-my-pokemon`, true);
           // console.log(trainer)
            xhr.setRequestHeader("Content-Type", "application/json");
            console.log("Now sending request")
            xhr.send(JSON.stringify(trainer));     
            
        }
    


  public viewMyPokemonStatus(trainerId: number) {

        console.log("in view my pokemon status service...")
        let xhr = new XMLHttpRequest();


        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);
                this.router.navigateByUrl('table/view-my-status');
            }
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
        xhr.open("GET", `/table/view-my-pokemon-status?${trainerId}`, true);
        xhr.send();



    }

    public viewMyPokePatients(nurseId: number) {

        console.log("in view my pokemon patients service...")
        let xhr = new XMLHttpRequest();


        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);
                this.router.navigateByUrl('table/view-my-pokepatients');
            }
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
        xhr.open("GET", `/table/view-my-pokepatients?${nurseId}`, true);
        xhr.send();


    }

    public viewPastPokePatients(nurseId: number) {

        console.log("in view my past pokemon patients service...")
        let xhr = new XMLHttpRequest();


        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);
                this.router.navigateByUrl('table/view-past-pokepatients');
            }
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
        xhr.open("GET", `/table/view-past-pokepatients?${nurseId}`, true);
        xhr.send();


    }

    public viewMyPokePatientCharts(nurseId: number) {

        console.log("in view my pokemon patient chart service...")
        let xhr = new XMLHttpRequest();


        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);
                this.router.navigateByUrl('table/view-my-pokepatient-charts');
            }
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
        xhr.open("GET", `table/view-my-pokepatient-charts?${nurseId}`, true);
        xhr.send();



    }

    public getPokeTreatmentByPatientId(patientId: number) {

        console.log("in view my pokemon treatment by patient id service...")
        let xhr = new XMLHttpRequest();


        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);
                this.router.navigateByUrl('table/get-poketreatment-by-patient-id');
            }
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
        xhr.open("GET", `table/get-poketreatment-by-patient-id?${patientId}`, true);
        xhr.send();



    }



    public viewAllAdmittedPatients() {

        console.log("in view my all patients service...")
        let xhr = new XMLHttpRequest();




        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);
                this.router.navigateByUrl('table/view-all-admitted-pokepatients');
            }
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
        xhr.open("GET", "table/view-all-admitted-pokepatients", true);
        xhr.send();



    }

    public viewAllPastPokePatients() {

        console.log("in view all past patients service...")
        let xhr = new XMLHttpRequest();




        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);
                this.router.navigateByUrl('table/view-all-past-pokepatients');
            }
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
        xhr.open("GET", "table/view-all-past-pokepatients", true);
        xhr.send();



    }


    public viewPokeCenterBilling() {

        console.log("in view all billing service...")
        let xhr = new XMLHttpRequest();




        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);
                this.router.navigateByUrl('table/view-billing');
            }
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
        xhr.open("GET", "table/view-billing", true);
        xhr.send();



    }

    public viewCurrentMedicationStock() {

        console.log("in view medicine stock service...")
        let xhr = new XMLHttpRequest();




        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);
                this.router.navigateByUrl('table/view-current-med-stock');
            }
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
        xhr.open("GET", "table/view-current-med-stock", true);
        xhr.send();



    }

    public viewAllUsers() {

        console.log("in view all users service...")
        let xhr = new XMLHttpRequest();




        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);
                this.router.navigateByUrl('table/view-all-users');
            }
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
        xhr.open("POST", "table/view-all-users", true);
        xhr.send();



    }











}
