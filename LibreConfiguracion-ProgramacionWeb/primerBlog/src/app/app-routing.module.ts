import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ListadoComponent } from './vistas/listado/listado.component';
import { PaginaNoEncontradaComponent } from './vistas/pagina-no-encontrada/pagina-no-encontrada.component';
import { AcercaDeNosotrosComponent } from './vistas/acerca-de-nosotros/acerca-de-nosotros.component';


const routes: Routes = [
  { path: 'listado', component: ListadoComponent },
  { path: 'nosotras', component: AcercaDeNosotrosComponent },


  { path: '', redirectTo: '/listado', pathMatch: 'full' },
  { path: '**', component: PaginaNoEncontradaComponent }
];


@NgModule({
  declarations: [],
  exports: [RouterModule],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class AppRoutingModule { }
