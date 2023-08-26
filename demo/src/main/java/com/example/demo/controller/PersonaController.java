package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.entity.Persona;

@RestController
public class PersonaController {
    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @PostMapping("/createPersona")
    public String createPersona(@RequestBody Persona persona) {
        Persona personaGuardada = personaRepository.save(persona);
        return "Persona Guardada: " + personaGuardada.getNombre();
    }
}
