export class Trainer{

    trainerId: number;
    username: String;
    password: string;
    firstName: string;
    hometown: string;


    constructor(trainerId : number, username: string, password: string, firstName: string, hometown: string){
        this.trainerId=  trainerId;
        this.username= username;
        this.password= password;
        this.firstName = firstName;
        this.hometown = hometown;
    }

}