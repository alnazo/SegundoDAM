package com.example.proyectospringlogin.service;

import com.example.proyectospringlogin.model.Usuario;
import com.example.proyectospringlogin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El email: " + email + " no existe"));

        Set<GrantedAuthority> authoritySet = user.getRoles()
                .stream().map(rol -> new SimpleGrantedAuthority(rol.getName()))
                .collect(Collectors.toSet());

        return new User(user.getEmail(), user.getPassword(), authoritySet);
    }
}
