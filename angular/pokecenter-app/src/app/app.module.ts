import { fakeBackendProvider, FakeBackendInterceptor } from './helpers/fake-pokecenter-backend';
//modules
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule, Title } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';

//components
import { AppComponent } from './app.component';
import { PasswordRecoveryComponent } from './components/password-recovery/password-recovery.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { HomeComponent } from './components/home/home.component';
import { SigninComponent } from './components/signin/signin.component';
import { NavbarComponent } from './components/home/navbar/navbar.component';
import { AlertComponent } from './components/alert/alert.component';
import { TableComponent } from './components/table/table.component';
import { AdmissionComponent } from './components/admission/admission.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { EmployeeRegistrationComponent } from './components/employee-registration/employee-registration.component';
import { TickerComponent } from './components/ticker/ticker.component';
import { AssignNurseComponent } from './components/assign-nurse/assign-nurse.component';
import { ViewMyPatientsComponent } from './components/view-my-patients/view-my-patients.component';
import { TreatPokepatientComponent } from './components/treat-pokepatient/treat-pokepatient.component';
import { SeeTreatmentOptionsComponent } from './components/see-treatment-options/see-treatment-options.component';
import { ViewAllPatientsComponent } from './components/view-all-patients/view-all-patients.component';
import { AuthorizeDischargeComponent } from './components/authorize-discharge/authorize-discharge.component';
import { CurrentMedicationStockComponent } from './components/current-medication-stock/current-medication-stock.component';
import { ViewAllUsersComponent } from './components/view-all-users/view-all-users.component';
import { ViewEmployeesComponent } from './components/view-employees/view-employees.component';

@NgModule({
  declarations: [
    AppComponent,
    PasswordRecoveryComponent,
    RegistrationComponent,
    HomeComponent,
    SigninComponent,
    NavbarComponent,
    AlertComponent,
    TableComponent,
    AdmissionComponent,
    DashboardComponent,
    EmployeeRegistrationComponent,
    TickerComponent,
    AssignNurseComponent,
    ViewMyPatientsComponent,
    TreatPokepatientComponent,
    SeeTreatmentOptionsComponent,
    ViewAllPatientsComponent,
    AuthorizeDischargeComponent,
    CurrentMedicationStockComponent,
    ViewAllUsersComponent,
    ViewEmployeesComponent
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [Title, fakeBackendProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
