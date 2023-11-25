package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/inquilino", produces = "application/json")
public class InquilinoController {
    private final UnidadRepository unidadRepository;
    private final PersonaRepository personaRepository;

    @Autowired
    public InquilinoController(
            PersonaRepository personaRepository,
            UnidadRepository unidadRepository) {
        this.personaRepository = personaRepository;
        this.unidadRepository = unidadRepository;
    }

}
