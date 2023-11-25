package com.example.demo.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Duenio;
import com.example.demo.entity.Persona;
import com.example.demo.entity.Unidad;
import com.example.demo.requests.AltaDuenioRequest;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/duenio", produces = "application/json")
public class DuenioController {
    private final DuenioRepository duenioRepository;
    private final PersonaRepository personaRepository;
    private final UnidadRepository unidadRepository;

    @Autowired
    public DuenioController(DuenioRepository duenioRepository,
            PersonaRepository personaRepository,
            UnidadRepository unidadRepository) {
        this.duenioRepository = duenioRepository;
        this.personaRepository = personaRepository;
        this.unidadRepository = unidadRepository;
    }

}
