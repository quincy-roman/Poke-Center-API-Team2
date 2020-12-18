import { API_URL } from 'src/environments/environment.prod';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class TableService {

    constructor(private http: HttpClient, private router: Router) { }



    public converttime(time) {
        var d = new Date(time);
        var formattedDate = (d.getMonth() + 1) + "/" + d.getDate() + "/" + d.getFullYear();
        var hours = (d.getHours() < 10) ? "0" + d.getHours() : d.getHours();
        var minutes = (d.getMinutes() < 10) ? "0" + d.getMinutes() : d.getMinutes();

        var h: number = Number(hours);
        var m: number = Number(minutes);
        var hr = "AM";
        if (hours > 12) {
            hours = h - 12;
            hr = "PM";
        } else if (hours == 0) {
            hours = 12;
        }

        var formattedTime = hours + ":" + minutes + " " + hr;

        formattedDate = formattedDate + " " + formattedTime;
        if (formattedDate != null) {
            return formattedDate;
        } else {
            return "-"
        }

    }


    public viewMyPokemon(trainerId: number) {

        let user = JSON.parse(sessionStorage.getItem('currentUser'))
        console.log("now starting ajax request")
        console.log(user)
        console.log(user.trainerid)

        console.log("in view my pokemon service...")
        let xhr = new XMLHttpRequest();
        let trainer = {
            trainerId: user.trainerid,
            trainerName: user.name,
            hometown: user.hometown,
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




                            let pokemonPatientId = row.insertCell(0);

                            let pokemonDexId = row.insertCell(1);
                            let trainersId = row.insertCell(2);


                            let admission = row.insertCell(3);
                            let release = row.insertCell(4);
                            let currentHP = row.insertCell(5);
                            let maxHP = row.insertCell(6);
                            let statusId = row.insertCell(7);
                            let medId = row.insertCell(8);
                            let healthy = row.insertCell(9);

                            pokemonPatientId.innerHTML = d.patientid;
                            pokemonDexId.innerHTML = d.pokemonDexId;
                            trainersId.innerHTML = d.trainersId;


                            admission.innerHTML = this.converttime(d.admission);
                            release.innerHTML = this.converttime(d.release);
                            currentHP.innerHTML = d.currentHP;
                            maxHP.innerHTML = d.maxHP;
                            switch (d.statusId) {
                                case 1:
                                    statusId.innerHTML = "Burn";
                                    break;
                                case 2:
                                    statusId.innerHTML = "Sleep";
                                    break;
                                case 3:
                                    statusId.innerHTML = "Freeze";
                                    break;
                                case 4:
                                    statusId.innerHTML = "Poison";
                                    break;
                                case 5:
                                    statusId.innerHTML = "Paralysis";
                                    break;
                                case 6:
                                    statusId.innerHTML = "Fainted";
                                    break;
                            }
                            medId.innerHTML = d.statusId;
                            healthy.innerHTML = d.healthy;
                        })
                    }

                }
                this.router.navigateByUrl('trainer/table/view-my-pokemon')


            } if (xhr.readyState === 4 && xhr.status > 200) {
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

        let user = JSON.parse(sessionStorage.getItem('currentUser'))


        let role = {
            roleid: 1,
            role: "Nurse"
        }

        let nurseTemplate = {

            employeeId: user.empid,
            employeeName: user.name,
            username: user.username,
            password: user.password,
            role: role
        }


        console.log(nurseTemplate)
        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);

                console.log(sessionStorage.getItem('tableData'))
                //table logic
                console.log("Successfully retrieved data from server")

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




                            let pokemonPatientId = row.insertCell(0);

                            let pokemonDexId = row.insertCell(1);
                            let trainersId = row.insertCell(2);


                            let admission = row.insertCell(3);
                            let release = row.insertCell(4);
                            let currentHP = row.insertCell(5);
                            let maxHP = row.insertCell(6);
                            let statusId = row.insertCell(7);
                            let medId = row.insertCell(8);
                            let healthy = row.insertCell(9);

                            pokemonPatientId.innerHTML = d.patientid;
                            pokemonDexId.innerHTML = d.pokemonDexId;
                            trainersId.innerHTML = d.trainersId;


                            admission.innerHTML = this.converttime(d.admission);
                            release.innerHTML = this.converttime(d.release);
                            currentHP.innerHTML = d.currentHP;
                            maxHP.innerHTML = d.maxHP;
                            switch (d.statusId) {
                                case 1:
                                    statusId.innerHTML = "Burn";
                                    break;
                                case 2:
                                    statusId.innerHTML = "Sleep";
                                    break;
                                case 3:
                                    statusId.innerHTML = "Freeze";
                                    break;
                                case 4:
                                    statusId.innerHTML = "Poison";
                                    break;
                                case 5:
                                    statusId.innerHTML = "Paralysis";
                                    break;
                                case 6:
                                    statusId.innerHTML = "Fainted";
                                    break;
                            }
                            medId.innerHTML = d.statusId;
                            healthy.innerHTML = d.healthy;
                        })
                    }

                }



                //end of table logic
                this.router.navigateByUrl('nurse/table/view-my-pokepatients');
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
        xhr.open("POST", `${API_URL}nurse/table/view-my-pokepatients`, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(nurseTemplate));


    }


    public getTreatmentByStatus(statusId: number) {

        console.log("in view treatement by status service...")
        let xhr = new XMLHttpRequest();

        let status = '';
        switch (statusId) {
            case 1:
                status = "Burn";
                break;
            case 2:
                status = "Sleep";
                break;
            case 3:
                status = "Freeze";
                break;
            case 4:
                status = "Poison";
                break;
            case 5:
                status = "Paralysis";
                break;
            case 6:
                status = "Fainted";
                break;
        }

        let statusTemplate = {
            statusId: statusId,
            status: status

        }



        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")

                sessionStorage.setItem('tableData', xhr.responseText);

                console.log(sessionStorage.getItem('tableData'))
                //table logic
                console.log("Successfully retrieved data from server")

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








                            let medicineId = row.insertCell(0);

                            let medName = row.insertCell(1);
                            let price = row.insertCell(2);


                            let quantity = row.insertCell(3);
                            let useCase = row.insertCell(4);


                            medicineId.innerHTML = d.medId;
                            medName.innerHTML = d.medName;
                            price.innerHTML = d.cost;


                            quantity.innerHTML = d.stock;
                            //  useCase.innerHTML = ///VARIABLE WE COLLECT);

                            switch (statusId) {
                                case 1:
                                    useCase.innerHTML = "Burn";
                                    break;
                                case 2:
                                    useCase.innerHTML = "Sleep";
                                    break;
                                case 3:
                                    useCase.innerHTML = "Freeze";
                                    break;
                                case 4:
                                    useCase.innerHTML = "Poison";
                                    break;
                                case 5:
                                    useCase.innerHTML = "Paralysis";
                                    break;
                                case 6:
                                    useCase.innerHTML = "Fainted";
                                    break;
                            }

                        })
                    }

                }



                //end of table logic
                this.router.navigateByUrl('nurse/table/get-poketreatment-by-patient-id');
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
        xhr.open("POST", `${API_URL}nurse/table/get-poketreatment-by-patient-id`, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(statusTemplate));


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

        console.log("in view all admitted patients service...")
        let xhr = new XMLHttpRequest();



        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);

                console.log(sessionStorage.getItem('tableData'))
                //table logic
                console.log("Successfully retrieved data from server")

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




                            let pokemonPatientId = row.insertCell(0);

                            let pokemonDexId = row.insertCell(1);
                            let trainersId = row.insertCell(2);


                            let admission = row.insertCell(3);
                            let release = row.insertCell(4);
                            let currentHP = row.insertCell(5);
                            let maxHP = row.insertCell(6);
                            let statusId = row.insertCell(7);
                            let medId = row.insertCell(8);
                            let healthy = row.insertCell(9);

                            pokemonPatientId.innerHTML = d.patientid;
                            pokemonDexId.innerHTML = d.pokemonDexId;
                            trainersId.innerHTML = d.trainersId;


                            admission.innerHTML = this.converttime(d.admission);
                            release.innerHTML = this.converttime(d.release);
                            currentHP.innerHTML = d.currentHP;
                            maxHP.innerHTML = d.maxHP;
                            switch (d.statusId) {
                                case 1:
                                    statusId.innerHTML = "Burn";
                                    break;
                                case 2:
                                    statusId.innerHTML = "Sleep";
                                    break;
                                case 3:
                                    statusId.innerHTML = "Freeze";
                                    break;
                                case 4:
                                    statusId.innerHTML = "Poison";
                                    break;
                                case 5:
                                    statusId.innerHTML = "Paralysis";
                                    break;
                                case 6:
                                    statusId.innerHTML = "Fainted";
                                    break;
                            }
                            medId.innerHTML = d.statusId;
                            healthy.innerHTML = d.healthy;
                        })
                    }

                }



                //end of table logic
                // alert("All PokePatients have succe")
                this.router.navigateByUrl('admin/table/view-patients');
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
        xhr.open("GET", `${API_URL}admin/table/view-patients`, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send();

    }


    public viewAllPatientsRemoval() {

        console.log("in view all admitted patients service...")
        let xhr = new XMLHttpRequest();



        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);

                console.log(sessionStorage.getItem('tableData'))
                //table logic
                console.log("Successfully retrieved data from server")

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




                            let pokemonPatientId = row.insertCell(0);

                            let pokemonDexId = row.insertCell(1);
                            let trainersId = row.insertCell(2);


                            let admission = row.insertCell(3);
                            let release = row.insertCell(4);
                            let currentHP = row.insertCell(5);
                            let maxHP = row.insertCell(6);
                            let statusId = row.insertCell(7);
                            let medId = row.insertCell(8);
                            let healthy = row.insertCell(9);

                            pokemonPatientId.innerHTML = d.patientid;
                            pokemonDexId.innerHTML = d.pokemonDexId;
                            trainersId.innerHTML = d.trainersId;


                            admission.innerHTML = this.converttime(d.admission);
                            release.innerHTML = this.converttime(d.release);
                            currentHP.innerHTML = d.currentHP;
                            maxHP.innerHTML = d.maxHP;
                            switch (d.statusId) {
                                case 1:
                                    statusId.innerHTML = "Burn";
                                    break;
                                case 2:
                                    statusId.innerHTML = "Sleep";
                                    break;
                                case 3:
                                    statusId.innerHTML = "Freeze";
                                    break;
                                case 4:
                                    statusId.innerHTML = "Poison";
                                    break;
                                case 5:
                                    statusId.innerHTML = "Paralysis";
                                    break;
                                case 6:
                                    statusId.innerHTML = "Fainted";
                                    break;
                            }
                            medId.innerHTML = d.statusId;
                            healthy.innerHTML = d.healthy;
                        })
                    }

                }



                //end of table logic
                // alert("All PokePatients have succe")
                this.router.navigateByUrl('admin/remove-record');
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
        xhr.open("GET", `${API_URL}admin/table/view-patients`, true);
        xhr.setRequestHeader("Content-Type", "application/json");
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

        console.log("in view current med stock by status service...")
        let xhr = new XMLHttpRequest();

        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")

                sessionStorage.setItem('tableData', xhr.responseText);

                console.log(sessionStorage.getItem('tableData'))
                //table logic
                console.log("Successfully retrieved data from server")

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


                            let medicineId = row.insertCell(0);

                            let medName = row.insertCell(1);
                            let price = row.insertCell(2);


                            let quantity = row.insertCell(3);
                            let useCase = row.insertCell(4);


                            medicineId.innerHTML = d.medId;
                            medName.innerHTML = d.medName;
                            price.innerHTML = d.cost;


                            quantity.innerHTML = d.stock;



                        })
                    }

                }



                //end of table logic
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
        xhr.open("GET", `${API_URL}admin/table/view-current-med-stock`, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send();


    }
    public viewAllTrainersRemoval() {

        console.log("in view all trainers1 service...")
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);
                //table logic

                //table logic
                console.log("Successfully retrieved data from server")

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
                            let trainerId = row.insertCell(0);
                            let trainerName = row.insertCell(1);
                            let hometown = row.insertCell(2);
                            let username = row.insertCell(3);
                            let password = row.insertCell(4);
                            trainerId.innerHTML = d.trainerid;
                            trainerName.innerHTML = d.name;
                            hometown.innerHTML = d.hometown;
                            username.innerHTML = d.username;
                            password.innerHTML = d.password;
                        })

                        //end of table logic

                    } this.router.navigate(['/admin/remove-trainer']);

                } 
            }if (xhr.readyState === 4 && xhr.status > 200) {
                    console.log("Failed. Status Code: " + xhr.status)
                    var reason = {
                        code: xhr.status,
                        issue: 'Failed to load table data from server.'
                    };
                    console.log(reason);
                    sessionStorage.setItem('failMessage', JSON.stringify(reason));
                    let message = JSON.parse(sessionStorage.getItem('failMessage'));
                    //goes to error interceptor
                    alert(`Status Code: ${message.code} - ${message.issue}`);
                    //renavigate to home page
                    this.router.navigateByUrl('/home');
                }
                console.log("Processing")
            }
            xhr.open("GET", `${API_URL}admin/table/view-trainers`, true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.send();
        }
    public viewAllTrainers() {

        console.log("in view all trainers1 service...")
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);
                //table logic

                //table logic
                console.log("Successfully retrieved data from server")

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
                            let trainerId = row.insertCell(0);
                            let trainerName = row.insertCell(1);
                            let hometown = row.insertCell(2);
                            let username = row.insertCell(3);
                            let password = row.insertCell(4);
                            trainerId.innerHTML = d.trainerid;
                            trainerName.innerHTML = d.name;
                            hometown.innerHTML = d.hometown;
                            username.innerHTML = d.username;
                            password.innerHTML = d.password;
                        })

                        //end of table logic

                    } this.router.navigate(['/admin/table/view-trainers']);

                } 
            }if (xhr.readyState === 4 && xhr.status > 200) {
                    console.log("Failed. Status Code: " + xhr.status)
                    var reason = {
                        code: xhr.status,
                        issue: 'Failed to load table data from server.'
                    };
                    console.log(reason);
                    sessionStorage.setItem('failMessage', JSON.stringify(reason));
                    let message = JSON.parse(sessionStorage.getItem('failMessage'));
                    //goes to error interceptor
                    alert(`Status Code: ${message.code} - ${message.issue}`);
                    //renavigate to home page
                    this.router.navigateByUrl('/home');
                }
                console.log("Processing")
            }
            xhr.open("GET", `${API_URL}admin/table/view-trainers`, true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.send();
        }
    

    public viewAllEmployees() {

        console.log("in view all employees service...")
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = () => {
            console.log('ReadyState: ' + xhr.readyState);
            if (xhr.readyState <= 3) {
                console.log('loading');
            }
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log("Success")
                sessionStorage.setItem('tableData', xhr.responseText);
                //table logic

                //table logic
                console.log("Successfully retrieved data from server")

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
                            let empid = row.insertCell(0);
                            let username = row.insertCell(1);
                            let password = row.insertCell(2);
                            let name = row.insertCell(3);
                            let roleid = row.insertCell(4);

                            console.log(d.roleid)
                            if(d.roleId==1){                                 
                                roleid.innerHTML="Nurse"

                            }else{
                                roleid.innerHTML ="Admin"
                            }

                            empid.innerHTML = d.empid;
                            username.innerHTML = d.username;
                            password.innerHTML = d.password;
                            name.innerHTML = d.name;
                            //roleid.innerHTML = d.roleId;
                            
                        })

                        //end of table logic

                    } this.router.navigate(['/admin/table/view-employees']);

                } 
            }if (xhr.readyState === 4 && xhr.status > 200) {
                    console.log("Failed. Status Code: " + xhr.status)
                    var reason = {
                        code: xhr.status,
                        issue: 'Failed to load table data from server.'
                    };
                    console.log(reason);
                    sessionStorage.setItem('failMessage', JSON.stringify(reason));
                    let message = JSON.parse(sessionStorage.getItem('failMessage'));
                    //goes to error interceptor
                    alert(`Status Code: ${message.code} - ${message.issue}`);
                    //renavigate to home page
                    this.router.navigateByUrl('/home');
                }
                console.log("Processing")
            }
            xhr.open("GET", `${API_URL}admin/table/view-employees`, true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.send();
        }
    }












