import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule  } from './app-routing.module';
import { AppComponent } from './app.component';
import { DriveComponent } from './drive/drive.component';
import { NavbarComponent } from './navbar/navbar.component';

import { AuthService } from './services/auth.service';
import { LoginComponent } from './login/login.component';
import { GoogleService } from './services/google.service';
import { WelcomeComponent } from './welcome/welcome.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    WelcomeComponent,
    DriveComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    HttpClientModule
  ],
  providers: [  AuthService,GoogleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
