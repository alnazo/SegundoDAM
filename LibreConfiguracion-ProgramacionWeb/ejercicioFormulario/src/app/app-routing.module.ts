import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormLoginComponent } from './view/form-login/form-login.component';
import { FormRegisterComponent } from './view/form-register/form-register.component';
import { HomeComponent } from './view/home/home.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: FormLoginComponent},
  {path: 'register', component: FormRegisterComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
