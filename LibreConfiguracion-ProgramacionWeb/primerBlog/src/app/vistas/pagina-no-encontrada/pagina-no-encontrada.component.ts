import { Component } from '@angular/core';

@Component({
  selector: 'app-pagina-no-encontrada',
  templateUrl: './pagina-no-encontrada.component.html',
  styleUrls: ['./pagina-no-encontrada.component.css']
})
export class PaginaNoEncontradaComponent {
  http_error_img = "https://http.cat/404.jpg";
}
