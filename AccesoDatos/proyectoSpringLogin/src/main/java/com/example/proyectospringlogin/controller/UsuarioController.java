package com.example.proyectospringlogin.controller;

import com.example.proyectospringlogin.model.Usuario;
import com.example.proyectospringlogin.repository.UsuarioRepository;
import com.example.proyectospringlogin.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioService usuarioService;

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

    @PostMapping("/login")
    public RedirectView loginForm(@RequestBody Usuario user){

        usuarioService.loadUserByUsername(user.getEmail());

        return new RedirectView("/");
    }

    @GetMapping("/register")
    public ModelAndView registro(){
        ModelAndView mv = new ModelAndView("register");
        mv.addObject("user", new Usuario());

        return mv;
    }

    @PostMapping("/register")
    public RedirectView registroForm(Usuario user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        usuarioRepository.save(user);

        return new RedirectView("/");
    }


    @GetMapping("/users/home")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("user/home");
        return mv;
    }

}
