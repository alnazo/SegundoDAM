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
	public ModelAndView mensaje(@RequestParam(value = "curso", defaultValue = "Segundo de DAM") String curso, @RequestParam(value = "cat", defaultValue = "502") String cat){
		ModelAndView mv = new ModelAndView("home");
		String url = "https://http.cat/images/" + cat + ".jpg";
		mv.addObject("curso", curso);
		mv.addObject("cat", url);

		return mv;
	}

	@GetMapping("/tabla")
	public ModelAndView tabla(){
		ModelAndView mv = new ModelAndView("tabla");

		String[][] tab = {
			{"1", "Alma", "España"},
			{"2", "Juan", "España"},
			{"3", "Mariana", "Mexico"},
			{"4", "Jesus", "Canada"}
		};
		mv.addObject("content", tab);

		return mv;
	}

}
