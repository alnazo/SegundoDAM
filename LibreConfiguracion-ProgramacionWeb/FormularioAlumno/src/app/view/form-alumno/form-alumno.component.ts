import { Component } from '@angular/core';
import { Alumno } from 'src/app/model/alumno';

@Component({
  selector: 'app-form-alumno',
  templateUrl: './form-alumno.component.html',
  styleUrls: ['./form-alumno.component.css']
})
export class FormAlumnoComponent {
  alumno: Alumno = new Alumno('', '', 0, '');

  onSubmit() {
    console.log(this.alumno);
  }

}
