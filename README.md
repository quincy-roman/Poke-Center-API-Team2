# PokeCenter API : Hospital Management System 
<img style="float: right;" src="https://i.imgur.com/9WXfW7z.png" alt="pokecenter-api-icon">

## Revature Project #2

### Team Members:
- Azhya Knox (FrontEnd Development)
- Grayson McClellan (FrontEnd Development)
- Quincy Roman (Team Lead, BackEnd Development)
- Mareo Yapp  (BackEnd Development)

### Summary
* Nurses of the PokeCenter calculates the most cost-efficient medication for the pokemon and adminster that treatment.
* Any admitted pokemon has randomly generate stat values using calculations within PokeCenter API logic. This logic will consume the PokeAPI data and manipulate this data for the PokeCenter API.

#### Trainer User Stories 
- A Trainer can login.
- A Trainer can view the Trainer Homepage.
- A Trainer can logout.
- A Trainer can view their Pokemon.
- A Trainer can view the status of their Pokemon and stats.
- A Trainer can view their information.
- A Trainer can update their information.

#### Nurse User Stories 
- A Nurse can login.
- A Nurse can view the Nurse Homepage.
- A Nurse can logout.
- A Nurse can view the Pokemon under their care.
- A Nurse can view the status of their Pokemon and stats.
- A Nurse can receive recommended medicines based on the particular patient. 
- A Nurse can administer treatment.
- A Nurse can approve release.
- A Nurse can view all admitted Pokemon.
- A Nurse can view past records.

#### Admin User Stories
- An Admin can login.
- An Admin can view the Admin Homepage.
- An Admin can logout.
- An Admin can discharge patients.
- An Admin can view current medication stock.
- An Admin can view all users (trainers, nurses, patients).

### Technical Requirements

* The back-end system uses **Hibernate** to connect to an **AWS RDS Postgres database**. 
* The application is deployed onto an Apache Tomcat Server. 
* The middle tier uses Spring MVC for dynamic Web application development. 
* The front-end view uses Angular to make a single-page application that can call server-side components.
* The API follows REST by making HTTP requests between client and server using Angular services and interceptors.
* The middle tier follows a front controller, layered architecture to achieve efficient Agile development.
* The application implements log4j for appropriate logging. 

**User Types**
Three User types: Admin, Nurse, Trainer
