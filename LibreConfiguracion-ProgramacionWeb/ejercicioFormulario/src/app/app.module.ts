import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { FormLoginComponent } from './view/form-login/form-login.component';
import { FormRegisterComponent } from './view/form-register/form-register.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './view/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    FormLoginComponent,
    FormRegisterComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
