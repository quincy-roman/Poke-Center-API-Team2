# PokeCenter API : Hospital Management System 
<img style="float: right;" src="https://i.imgur.com/9WXfW7z.png" alt="pokecenter-api-icon">

## Revature Project #2

## Team Members:
- Azhya Knox (FrontEnd Development)
- Grayson McClellan (FrontEnd Development)
- Quincy Roman (Team Lead, BackEnd Development)
- Mareo Yapp  (BackEnd Development)

## Summary
* Send the trainer a message if their Pokemon has Pokerus.
* Any PokeCenter employee calculates the most cost-efficient medication for the pokemon and adminster that treatment.
* Any admitted pokemon has randomly generate stat values using calculations within PokeCenter API logic. This logic will consume the PokeAPI data and manipulate this data for the PokeCenter API.
* Additional feature: Each trainer can modify current party and items at the PC Box Terminal.

#### Trainer User Stories 
- A Trainer can login
- A Trainer can view the Trainer Homepage
- A Trainer can logout
- A Trainer can view their Pokemon
- A Trainer can view the status of their Pokemon and stats.
- A Trainer can get alerts when their Pokemon are healed via email or notification bar.
- A Trainer can store excess pokemon in the the trainer's PC box (reminiscent of the PC in the games).
- A Trainer can view their information
- A Trainer can update their information

#### Nurse User Stories 
- A Nurse can login
- A Nurse can view the Nurse Homepage
- A Nurse can logout
- A Nurse can view the Pokemon under their care
- A Nurse can view the status of their Pokemon and stats.
- A Nurse can administer treatment
- A Nurse can calculate the best medical treatment based on HP lost and status effects.
- A Nurse can approve release (with timestamp).
- A Nurse can update their information 
- A Nurse can view all admitted Pokemon.
- A Nurse can view past records.

#### Admin User Stories
- An Admin can login
- An Admin can view the Admin Homepage
- An Admin can logout
- An Admin can view billing history
- An Admin can view current medication stock.
- An Admin can modify users roles.
- An Admin can place orders for more medication.
- An Admin can view all users (trainers, nurses, Pokemon, both).
- An Admin can remove users/records if necessary.

## Technical Requirements

* The back-end system uses **Hibernate** to connect to an **AWS RDS Postgres database**. 
* The application is deployed onto an Apache Tomcat Server. 
* The middle tier uses Spring MVC for dynamic Web application development. 
* The front-end view uses Angular to make a single-page application that can call server-side components.
* The API follows REST by making HTTP requests between client and server using Angular services and interceptors.
* Passwords are encrypted in Java using BCrypt and securely stored in the database. 
* The middle tier follows a front controller, layered architecture to achieve efficient Agile development.
* The application has reasonable test coverage thanks to:
    - JUnit and Mockito on the backend
    - Jasmine and Karma on the frontend.
* The application implements log4j for appropriate logging. 

**User Types**
Three User types: Admin, Nurse, Trainer

## Visual Aids
- none available at this time