import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotFoundComponent } from './view/not-found/not-found.component';
import { InformacionComponent } from './view/informacion/informacion.component';
import { HttpcatsComponent } from './view/httpcats/httpcats.component';
import { HomeComponent } from './view/home/home.component';

const routes: Routes = [
  {path:"", component: HomeComponent},
  {path:"info", component: InformacionComponent},
  {path:"cats", component: HttpcatsComponent},

  {path:"**", component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
