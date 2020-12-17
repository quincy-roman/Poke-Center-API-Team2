export class Trainer {
    trainerId: number;
    name: string;
    hometown: string;
    username: string;
    password: string;

    constructor(trainerId: number, name: string, hometown: string, username: string, password: string) {
        this.trainerId = trainerId;
        this.name = name;
        this.hometown = hometown;
        this.username = username;
        this.password = password;
    }
}