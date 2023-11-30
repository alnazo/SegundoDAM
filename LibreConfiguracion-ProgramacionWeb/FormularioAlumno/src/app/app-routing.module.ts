import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormAlumnoComponent } from './view/form-alumno/form-alumno.component';
import { HomeComponent } from './view/home/home.component';

const routes: Routes = [
  { path: "", component:  HomeComponent },
  { path: "alumform", component: FormAlumnoComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
