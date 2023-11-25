package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Persona;
import com.example.demo.views.PersonaView;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/persona", produces = "application/json")
public class PersonaController {
    private final Controlador controlador;

    @Autowired
    public PersonaController(Controlador controlador) {
        this.controlador = controlador;
    }

    @GetMapping("/listar")
    public List<PersonaView> personaListar() {
        // Nos devuelve todos los datos que contiene la tabla personas.
        return this.controlador.getPersonas();
    }

    @PostMapping()
    public ResponseEntity<?> guardarPersona(@RequestBody Persona persona) {
        // Guarda un objeto persona en la base
        PersonaView nuevaPersona = controlador.agregarPersona(persona);
        if (nuevaPersona == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La persona no existe: " + persona.toView());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPersona);
    }

}