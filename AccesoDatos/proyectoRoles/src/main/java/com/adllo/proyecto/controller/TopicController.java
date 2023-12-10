package com.adllo.proyecto.controller;

import com.adllo.proyecto.dto.CommnetDTO;
import com.adllo.proyecto.dto.TopicDTO;
import com.adllo.proyecto.model.Comment;
import com.adllo.proyecto.model.Topic;
import com.adllo.proyecto.model.Usuario;
import com.adllo.proyecto.service.CommentService;
import com.adllo.proyecto.service.TopicService;
import com.adllo.proyecto.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String newTopic(Model model){
        model.addAttribute("topic", new TopicDTO());

        return "topic/index";
    }

    @PostMapping("/nuevo/topic")
    public String addTopic(@Valid @ModelAttribute("Topic") TopicDTO topicDTO){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = usuarioService.findByEmail(auth.getName());

        topicDTO.setCreateAt(LocalDateTime.now());
        topicDTO.setCreator(user);

        topicService.createTopic(topicDTO);

        return "redirect:/";

    }

    @GetMapping("/{id}")
    public String viewTopic(@PathVariable Long id, Model model){
        Topic topic = topicService.findById(id).orElse(null);

        if (topic == null){
            return "redirect:/?errtopic";
        }

        model.addAttribute("topic", topic);
        model.addAttribute("coment", new Comment());

        return "topic/topic";
    }

    @PostMapping("/{id}")
    public String addCommnet(@PathVariable Long id, CommnetDTO comment){
        Topic topic = topicService.findById(id).orElseThrow();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = usuarioService.findByEmail(auth.getName());

        comment.setTopic(topic);
        comment.setCreator(user);

        commentService.createComment(comment);

        return "redirect:/topic/"+id;

    }


}
