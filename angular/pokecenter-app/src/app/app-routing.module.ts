import { ViewEmployeesComponent } from './components/view-employees/view-employees.component';
import { ViewAllUsersComponent } from './components/view-all-users/view-all-users.component';
import { CurrentMedicationStockComponent } from './components/current-medication-stock/current-medication-stock.component';
import { AuthorizeDischargeComponent } from './components/authorize-discharge/authorize-discharge.component';
import { ViewAllPatientsComponent } from './components/view-all-patients/view-all-patients.component';
import { SeeTreatmentOptionsComponent } from './components/see-treatment-options/see-treatment-options.component';
import { TreatPokepatientComponent } from './components/treat-pokepatient/treat-pokepatient.component';
import { ViewMyPatientsComponent } from './components/view-my-patients/view-my-patients.component';
import { AssignNurseComponent } from './components/assign-nurse/assign-nurse.component';
import { EmployeeRegistrationComponent } from './components/employee-registration/employee-registration.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AdmissionComponent } from './components/admission/admission.component';
import { TableComponent } from './components/table/table.component';
import { SigninComponent } from './components/signin/signin.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { PasswordRecoveryComponent } from './components/password-recovery/password-recovery.component';

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  {
    path: "password-recovery",
    component: PasswordRecoveryComponent
  },
  {
    path: "trainer/registration",
    component: RegistrationComponent
  },
  {
    path: "employee/registration",
    component: EmployeeRegistrationComponent
  },

  {
    path: "signin",
    component: SigninComponent
  },
  {
    path: "trainer",
    component: DashboardComponent
  },
  {
    path: "nurse/table/view-my-pokepatients",
    component: ViewMyPatientsComponent
  },
  {
    path: "table/view-current-med-stock",
    component: CurrentMedicationStockComponent
  },
  {
    path: "nurse/update/my-pokepatient-charts",
    component: TreatPokepatientComponent
  },
  {
    path: "nurse/table/get-poketreatment-by-patient-id",
    component: SeeTreatmentOptionsComponent
  },
  {
    path: "trainer/admission",
    component: AdmissionComponent
  },
  {
    path: "admin/table/view-patients",
    component: ViewAllPatientsComponent
  },
  {
    path: "treatment/authorize-discharge",
    component: AuthorizeDischargeComponent
  },
  {
    path: "home",
    component: HomeComponent,
  },
  {
    path: "table/view-my-pokemon",
    component: TableComponent

  },
  {
    path: "trainer/table/view-my-pokemon",
    component: TableComponent

  },
  {
    path: "table/view-my-pokemon-stats",
    component: TableComponent
  },
  {
    path: "table/view-my-pokepatients",
    component: TableComponent
  },
  {
    path: "table/view-past-pokepatients",
    component: TableComponent
  },
  {
    path: "table/view-my-pokepatient-charts",
    component: TableComponent
  },
  {
    path: "table/get-poketreatment-by-patient-id",
    component: TableComponent
  },
  {
    path: "table/view-all-admitted-pokepatients",
    component: TableComponent
  },
  {
    path: "table/view-all-past-pokepatients",
    component: TableComponent
  },
  {
    path: "table/view-billing",
    component: TableComponent
  },
  {
    path: "admin/table/view-employees",
    component: ViewEmployeesComponent
  },
  {
    path: "table/view-current-med-stock",
    component: TableComponent
  },
  {
    path: "admin/table/view-trainers",
    component: ViewAllUsersComponent
  },
  {
    path: "admin/assign-nurse",
    component: AssignNurseComponent
  },
  {
    path: "",
    redirectTo: "/signin",
    pathMatch: "full"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
