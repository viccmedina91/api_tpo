package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.entity.Duenio;
import com.example.demo.entity.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonaController {
    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @PostMapping("/createUpdatePersona")
    public String createPersona(@RequestBody Persona persona) {
        /*
         * Endpoint para la creación de personas.
         * Por el momento se espera recibir un JSON como el siguiente:
         * {
         * "documento": 1234,
         * "nombre": "Juan",
         * "contrasenia": "1234"
         * }
         */
        Persona personaGuardada = personaRepository.save(persona);
        return "Persona Guardada: " + personaGuardada.getNombre();
    }

    @GetMapping("/personasByDocumento/{documento}")
    public ResponseEntity<Persona> getPersonaByDocumento(@PathVariable String documento) {
        /*
         * Endpoint para obtener una persona por medio del documento.
         * localhost:8080/personasByDocumento/1234
         */
        Optional<Persona> personaOptional = personaRepository.findByDocumento(documento);

        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            return ResponseEntity.ok(persona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAllPersonas")
    public ResponseEntity<List<Persona>> getAllPersonas() {
        /*
         * Nos devuelve todos los datos que contiene la tabla personas.
         */
        return ResponseEntity.ok(personaRepository.findAll());
    }

}
