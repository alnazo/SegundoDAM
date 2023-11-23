package com.example.proyectospringlogin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data @NoArgsConstructor @AllArgsConstructor
public class UsuarioDTO {

    @Email
    @NotEmpty(message = "El correo no puede estar vacio")
    private String email;

    @NotEmpty(message = "La contraseña no puede estar vacia")
    @Length(min = 6, max = 15, message = "La contraseña debe ser entre 6 a 15 caracteres")
    private String password;

}
