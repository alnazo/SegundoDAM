package com.adllo.proyecto.controller;

import com.adllo.proyecto.dto.UsuarioDTO;
import com.adllo.proyecto.model.Topic;
import com.adllo.proyecto.model.Usuario;
import com.adllo.proyecto.service.TopicService;
import com.adllo.proyecto.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TopicService topicService;


    @GetMapping("/")
    public String home(@RequestParam(name = "q", required = false, defaultValue = "") String q, Model model) {
        List<Topic> allTopics;

        if (q.isEmpty()){
            allTopics = topicService.allTopics();
        } else {
            allTopics = topicService.filterTopics(q);
        }

        model.addAttribute("topics", allTopics);

        return "index";
    }

    @GetMapping("/login")
    public String login() { return "forms/login"; }

    @GetMapping("/registro")
    public String register(Model model) {
        model.addAttribute("newUser", new UsuarioDTO());
        return "forms/registro";
    }

    @PostMapping("/registro")
    public String register(@Valid @ModelAttribute("usuarioDTO") UsuarioDTO user, BindingResult result, Model model){
        Usuario existsUser = usuarioService.findByEmail(user.getEmail());

        if (existsUser != null && existsUser.getEmail() != null && !existsUser.getEmail().isEmpty()) {
            result.rejectValue("email", null, "Ya existe un usuario con este email");
        }

        if (result.hasErrors()) {
            model.addAttribute("newUser", user);
            return "forms/registro";
        }

        usuarioService.createUsuario(user);
        model.addAttribute("nickname", user.getNickname());
        return "redirect:/login?success";
    }

}
