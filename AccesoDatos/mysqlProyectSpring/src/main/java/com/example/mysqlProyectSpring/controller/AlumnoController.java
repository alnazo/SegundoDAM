package com.example.mysqlProyectSpring.controller;


import com.example.mysqlProyectSpring.model.Alumno;
import com.example.mysqlProyectSpring.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class AlumnoController {

    @Autowired
    AlumnoRepository alumnoRepository;

    @GetMapping("/alumnos")
    public ModelAndView listaAlumnos(){
        List<Alumno> alumnos = alumnoRepository.findAll();
        ModelAndView mv = new ModelAndView("listaAlumnos");
        mv.addObject("alumnos", alumnos);
        return mv;
    }

    @GetMapping("/nuevoalumno")
    public ModelAndView nuevoAlum(){
        ModelAndView mv = new ModelAndView("nuevoAlumno");
        mv.addObject("alumno", new Alumno());
        return mv;
    }

    @PostMapping("/nuevoalumno")
    public RedirectView addAlum(Alumno al){
        alumnoRepository.save(al);
        return new RedirectView("/alumno");
    }

}
