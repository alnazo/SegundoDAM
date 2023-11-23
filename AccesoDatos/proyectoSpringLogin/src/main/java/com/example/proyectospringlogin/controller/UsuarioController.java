package com.example.proyectospringlogin.controller;

import com.example.proyectospringlogin.dto.UsuarioDTO;
import com.example.proyectospringlogin.model.Rol;
import com.example.proyectospringlogin.model.Usuario;
import com.example.proyectospringlogin.repository.RolRepository;
import com.example.proyectospringlogin.repository.UsuarioRepository;
import com.example.proyectospringlogin.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolRepository rolRepository;

    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("user", new Usuario());
        return mv;
    }


    @GetMapping("/register")
    public ModelAndView registro(){
        ModelAndView mv = new ModelAndView("register");
        mv.addObject("Usuario", new UsuarioDTO());

        return mv;
    }

    @PostMapping("/register")
    public RedirectView registroForm(@Valid @ModelAttribute("Usuario") UsuarioDTO usuariodto, BindingResult result){
        Usuario newUser = usuarioRepository.findByEmail(usuariodto.getEmail()).orElse(null);

        if (newUser != null && newUser.getEmail() != null && !newUser.getEmail().isEmpty()) {
            result.rejectValue("email", null, "Ya existe este email registrado.");
        }

        if (result.hasErrors()) {
            RedirectView rv = new RedirectView("/register?error");
            rv.setAttributesMap(result.getModel());
            return rv;
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(usuariodto.getPassword());
        newUser = new Usuario();
        newUser.setEmail(usuariodto.getEmail());
        newUser.setPassword(encodedPassword);

        usuarioRepository.save(newUser);
        return new RedirectView("/login?success");
    }


    @GetMapping("/users/home")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("user/home");
        return mv;
    }

    @GetMapping("/admin/list")
    public ModelAndView usersList(){
        ModelAndView mv = new ModelAndView("admin/list_users");
        List<Usuario> usuarios = usuarioRepository.findAll();

        mv.addObject("usuarios", usuarios);
        return mv;
    }

    @GetMapping("/admin/editar/{id}")
    public ModelAndView editUser(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("/admin/editar");

        mv.addObject("usuario", usuarioRepository.getReferenceById(id));
        mv.addObject("roles", rolRepository.findAll());

        return mv;
    }

    @PostMapping("/admin/editar/{id}")
    public RedirectView editRedirect(@PathVariable Long id, Usuario usuario, @RequestParam(name = "rolesgroup", required = false, defaultValue = "") List<Long> rolesIds){
        Usuario user = usuarioRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Usuario no encontrado") );
        user.setEmail(usuario.getEmail());

        List<Rol> rolesExistente = user.getRoles();
        rolesExistente.removeIf(rol -> !rolesIds.contains(rol.getId()));

        for (Long roleId : rolesIds) {
            Rol rol = rolRepository.findById(roleId).orElseThrow(() -> new IllegalArgumentException("Rol no encontrado"));
            if (!rolesExistente.contains(rol)) {
                rolesExistente.add(rol);
            }
        }

        user.setRoles(rolesExistente);

        usuarioRepository.save(user);

        return new RedirectView("/admin/list");
    }
}
