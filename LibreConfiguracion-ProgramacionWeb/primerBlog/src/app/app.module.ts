import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { ListadoComponent } from './vistas/listado/listado.component';
import { EntradaComponent } from './vistas/listado/entrada/entrada.component';
import { AppRoutingModule } from './app-routing.module';
import { PaginaNoEncontradaComponent } from './vistas/pagina-no-encontrada/pagina-no-encontrada.component';
import { AcercaDeNosotrosComponent } from './vistas/acerca-de-nosotros/acerca-de-nosotros.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    ListadoComponent,
    EntradaComponent,
    PaginaNoEncontradaComponent,
    AcercaDeNosotrosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
