package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Persona;
import com.example.demo.views.Login;
import com.example.demo.views.PersonaView;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
            return ResponseEntity.status(HttpStatus.OK)
                    .body("{\"mensaje\": \"" + "Error, el documento ya se encuentra registrado: "
                            + persona.getDocumento() + "\"}");
        }
        return ResponseEntity.ok(nuevaPersona);
    }

    @DeleteMapping("/{documento}")
    public ResponseEntity<?> eliminarPersona(@PathVariable("documento") String documento) {
        // Eliminar una persona segun el documento
        String operacion = this.controlador.eliminarPersona(documento);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{\"mensaje\": \"" + "El resultado de la operación es: "
                        + operacion + "\"}");

    }

    @PutMapping("/{documento}")
    public ResponseEntity<?> actualizarPersona(@RequestBody PersonaView persona,
            @PathVariable("documento") String documento) {
        String operacion = this.controlador.actualizarPersona(persona, documento);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{\"mensaje\": \"" + "El resultado de la operación es: "
                        + operacion + "\"}");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        // Guarda un objeto persona en la base
        return ResponseEntity.status(HttpStatus.OK)
                .body("{\"mensaje\": \"" + this.controlador.validarLogin(login) + "\"}");
    }
}