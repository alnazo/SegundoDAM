package com.example.proyectospringlogin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UsuarioDTO {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

}
