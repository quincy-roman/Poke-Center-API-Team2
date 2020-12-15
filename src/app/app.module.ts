import { TableService } from './../../angular/pokecenter-app/src/app/services/table.service';
import { fakeBackendProvider, FakeBackendInterceptor } from './helpers/fake-pokecenter-backend';
//modules
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule, Title } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';

import {TableService}
//components
import { AppComponent } from './app.component';
import { PasswordRecoveryComponent } from './components/password-recovery/password-recovery.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { HomeComponent } from './components/home/home.component';
import { SigninComponent } from './components/signin/signin.component';
import { NavbarComponent } from './components/home/navbar/navbar.component';
import { AlertComponent } from './components/alert/alert.component';
import { TableComponent } from './components/table/table.component';

@NgModule({
  declarations: [
    AppComponent,
    PasswordRecoveryComponent,
    RegistrationComponent,
    HomeComponent,
    SigninComponent,
    NavbarComponent,
    AlertComponent,
    TableComponent
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
