import { SigninComponent } from './components/signin/signin.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { PasswordRecoveryComponent } from './components/password-recovery/password-recovery.component';

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

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
