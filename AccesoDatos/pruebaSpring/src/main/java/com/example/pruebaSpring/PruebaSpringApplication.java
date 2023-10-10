package com.example.pruebaSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PruebaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaSpringApplication.class, args);
	}

	@GetMapping("/mensaje")
	public String mensaje(@RequestParam(value = "curso", defaultValue = "Segundo de DAM") String curso){
		return String.format("<h1>Hola %s ! </h1>", curso);
	}
}
