package com.adllo.proyecto.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UsuarioDTO {

    @NotEmpty(message = "Debes introducir tu correo electronico") @Email(message = "El correo introducido no es valido o esta repetido")
    private String email;

    @NotEmpty(message = "Debe introducir una contraseña")
    private String password;

    @NotEmpty(message = "Debes introducir tu nombre")
    private String name;

    @NotEmpty(message = "Debes introducir tu apellido")
    private String surname;

    @NotEmpty(message = "Debes introducir un seudonimo")
    private String nickname;

    @NotNull @Min(value = 13, message = "Debes ser mayor de 13 años")
    private Integer age;

}
