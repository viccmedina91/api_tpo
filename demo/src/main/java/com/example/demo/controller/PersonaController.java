package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.views.PersonaView;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

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
        /*
         * Nos devuelve todos los datos que contiene la tabla personas.
         */
        return this.controlador.getPersonas();
    }
    /*
     * 
     * 
     * @GetMapping("/buscar/{documento}")
     * public ResponseEntity<Persona> buscarPersona(@PathVariable String documento)
     * {
     * /*
     * Nos devuelve todos los datos que contiene la tabla personas.
     * 
     * 
     * Persona persona = personaRepository.findByDocumento(documento);
     * return ResponseEntity.ok(persona);
     * }
     * 
     * @PostMapping("/crear")
     * public ResponseEntity<String> crearPersona(@RequestBody Persona persona) {
     * try {
     * // Guarda la persona en la base de datos
     * personaRepository.save(persona);
     * return new ResponseEntity<>("Persona creada exitosamente",
     * HttpStatus.CREATED);
     * } catch (Exception e) {
     * return new ResponseEntity<>("Error al crear la persona",
     * HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     */
}