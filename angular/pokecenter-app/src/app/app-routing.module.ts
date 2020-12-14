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
    path: "registration",
    component: RegistrationComponent
  },
  {
    path: "signin",
    component: SigninComponent
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
    path: "table/view-current-med-stock",
    component: TableComponent
  },
  {
    path: "table/view-all-users",
    component: TableComponent
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
