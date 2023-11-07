package com.example.mysqlProyectSpring.controller;


import com.example.mysqlProyectSpring.model.Alumno;
import com.example.mysqlProyectSpring.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class AlumnoController {

    @Autowired
    AlumnoRepository alumnoRepository;

    @GetMapping("/alumnos")
    public ModelAndView listaAlumnos(@PageableDefault(size = 5) Pageable p){
        Page<Alumno> alumnos= alumnoRepository.findAll(p);
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
        return new RedirectView("/alumnos");
    }

    @GetMapping("/editaralumno")
    public ModelAndView editarAlumno(@RequestParam(value = "id") String id){
        ModelAndView mv = new ModelAndView("editarAlumno");
        Optional<Alumno> al = alumnoRepository.findById(Integer.valueOf(id));
        if (al.isPresent()){
            mv.addObject("alumno", al);
            return mv;
        } else {
            return new ModelAndView("redirect:/alumnos");
        }
    }

    @PostMapping("/editaralumno")
    public RedirectView editarAlumnoRedirect(Alumno al){
        alumnoRepository.save(al);
        return new RedirectView("/alumnos");
    }

    @PostMapping("/eliminaralumno")
    public RedirectView eliminarAlumno(int id){
        Optional<Alumno> alumno = alumnoRepository.findById(id);
        alumno.ifPresent(value -> alumnoRepository.delete(value));
        return new RedirectView("/alumnos");
    }

}
