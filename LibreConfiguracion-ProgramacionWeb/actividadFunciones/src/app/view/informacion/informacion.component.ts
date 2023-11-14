import { Component, OnInit } from '@angular/core';
import { Contacto } from 'src/app/compartidos/interfaces/contacto';

@Component({
  selector: 'app-informacion',
  templateUrl: './informacion.component.html',
  styleUrls: ['./informacion.component.css']
})
export class InformacionComponent implements OnInit{

  public listadoContactos: Contacto[];
  constructor() {
    this.listadoContactos = [
      {
        id: 1,
        nombre: "Antonio",
        apellido: "De Llamas",
        telefono: 123456
      },
      {
        id: 2,
        nombre: "Emilio",
        apellido: "Reina",
        telefono: 954789
      }
    ]
  }
  
  ngOnInit(): void{}
}

