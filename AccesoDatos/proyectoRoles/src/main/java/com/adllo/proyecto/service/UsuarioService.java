package com.adllo.proyecto.service;

import com.adllo.proyecto.dto.UsuarioDTO;
import com.adllo.proyecto.model.Rol;
import com.adllo.proyecto.model.Usuario;
import com.adllo.proyecto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void createUsuario(UsuarioDTO user) {
        Usuario newUser = new Usuario();

        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setEmail(user.getEmail());
        newUser.setNickname(user.getNickname());
        newUser.setAge(user.getAge());
        newUser.setRoles(Set.of(Rol.USER));
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        usuarioRepository.save(newUser);
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findUsuarioByEmail(email);
    }



   @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findUsuarioByEmail(email);

        Set<GrantedAuthority> authoritySet = user.getRoles()
                .stream().map(rol -> new SimpleGrantedAuthority(rol.name()))
                .collect(Collectors.toSet());

        return new User(user.getEmail(), user.getPassword(), authoritySet);
    }

}
