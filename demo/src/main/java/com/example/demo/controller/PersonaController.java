package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Persona;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/persona", produces = "application/json")
public class PersonaController {
    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearPersona(@RequestBody Persona persona) {
        try {
            // Guarda la persona en la base de datos
            personaRepository.save(persona);
            return new ResponseEntity<>("Persona creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la persona", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllPersonas")
    public ResponseEntity<List<Persona>> getAllPersonas() {
        /*
         * Nos devuelve todos los datos que contiene la tabla personas.
         */
        return ResponseEntity.ok(personaRepository.findAll());
    }

    @GetMapping("/buscar/{documento}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable String documento) {
        /*
         * Nos devuelve todos los datos que contiene la tabla personas.
         */

        Persona persona = personaRepository.findByDocumento(documento);
        return ResponseEntity.ok(persona);
    }
}