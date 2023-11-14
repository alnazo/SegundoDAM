package com.example.proyectospringlogin.controller;

import com.example.proyectospringlogin.model.Rol;
import com.example.proyectospringlogin.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    @PostMapping("/rol/save")
    public ResponseEntity<?> createRol(@RequestBody Rol rol){
        return ResponseEntity.status(HttpStatus.CREATED).body(rolRepository.save(rol));
    }
}
