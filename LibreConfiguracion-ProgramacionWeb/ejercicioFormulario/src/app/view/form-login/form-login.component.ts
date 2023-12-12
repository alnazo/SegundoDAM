import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/compartido/clases/usuario';
import { LoginService } from 'src/app/compartido/servicios/login.service';

@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.css']
})
export class FormLoginComponent implements OnInit {
  public usuario: Usuario;

  constructor(private loginService: LoginService, private router:Router){  
    this.usuario = new Usuario();
  }
  
  ngOnInit(): void {}
  
  public submit(): void {
    this.loginService.login(this.usuario).subscribe(
    (data : Number) => {
      localStorage.setItem('nombreUsuario', this.usuario.nombre);
      localStorage.setItem('miTokenPersonal',`${ data }`);
      this.router.navigate(['/listado']);
    },
    (error: Error) => {
      console.error("Error al realizar el acceso");
    })
  }
}
