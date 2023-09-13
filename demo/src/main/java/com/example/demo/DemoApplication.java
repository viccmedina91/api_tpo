package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Edificio;
import com.example.demo.entity.Persona;
import com.example.demo.entity.Reclamo;
import com.example.demo.repository.EdificioRepository;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.repository.ReclamoRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	EdificioRepository edificioRepository;

	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	ReclamoRepository reclamoRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	public void run(String... arg) throws Exception {
		Reclamo r = new Reclamo("ubicación ejemplo", "descripci;ón ejemplo", 2);
		Optional<Edificio> e = edificioRepository.findByCodigo(1);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(e.toString());
		Optional<Persona> p = personaRepository.findByDocumento("DNI29988738");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(p.toString());
		r.setEdificio(e.get());
		r.setPersona(p.get());
		reclamoRepository.save(r);
	}

}
