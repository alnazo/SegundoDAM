package com.example.proyectospringlogin.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Email
    @UniqueElements
    private String email;

    @NotEmpty
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = { @JoinColumn(name = "USER_ID", referencedColumnName = "ID") },
            inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") }
    )
    private List<Rol> roles;

}
