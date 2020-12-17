export class Employee {
    empId: number;
    name: string;
    roleId: number;
    username: string;
    password: string;

    constructor(empId: number, name: string, roleId: number, username: string, password: string) {
        this.empId = empId;
        this.name = name;
        this.roleId = roleId;
        this.username = username;
        this.password = password;
    }
}