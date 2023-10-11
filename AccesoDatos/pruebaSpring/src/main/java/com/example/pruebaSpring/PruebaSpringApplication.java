package com.example.pruebaSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
public class PruebaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaSpringApplication.class, args);
	}

	@GetMapping("/mensaje")
	public ModelAndView mensaje(@RequestParam(value = "curso", defaultValue = "Segundo de DAM") String curso){
		ModelAndView mv = new ModelAndView();

		mv.addObject("curso", curso);
		mv.setViewName("home.html");

		return mv;
	}
}
