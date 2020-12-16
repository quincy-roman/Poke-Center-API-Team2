export class Trainer {
    trainerId: number;
    firstName: string;
    hometown: string;
    username: string;
    password: string;

    constructor(trainerId: number, firstName: string, hometown: string, username: string, password: string) {
        this.trainerId = trainerId;
        this.firstName = firstName;
        this.hometown = hometown;
        this.username = username;
        this.password = password;
    }
}