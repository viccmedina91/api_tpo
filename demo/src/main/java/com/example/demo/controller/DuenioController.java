package com.example.demo.controller;

import java.util.List;
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

    @PostMapping("/crear")
    public ResponseEntity<String> createDuenio(@RequestBody AltaDuenioRequest drequest) {
        /*
         * Enpoint para crear un duenio. Se debe enviar lo siguiente
         * {
         * "identificador": 9999,
         * "documento": "DNI12344"
         * }
         * 
         * Tengo que controlar si el identificador existe, ya que ese valor es la
         * relación con unidadad.
         * Tengo que controlar si el dni existe. Por el momento, si no existe error.
         * Tiene que existir porque es la relación con Persona.
         */

        // Verificamos que la persona exista en la BD
        Persona persona = personaRepository.findByDocumento(drequest.getDocumento());
        if (persona == null) {
            System.out.println("El documento ingresado no se encuentra registrado");
            return ResponseEntity.accepted().body("El documento ingresado " +
                    "no se encuentra registrado");
        }
        // verificamos que la unidad ingresada exista
        Unidad unidad = unidadRepository.findUnidadByIdentificador(drequest.getIdentificador());
        if (unidad == null) {
            System.out.println("La unidad ingresada no existe");
            return ResponseEntity.accepted().body("La unidad ingresada no existe");

        }
        Duenio duenioSaved = new Duenio();
        duenioSaved.setPersona(persona);
        duenioRepository.save(duenioSaved);
        return ResponseEntity.accepted().body("200 OK - Nuevo Duenio alamcenado");
    }

    @GetMapping("/getByDocumento/{documento}")
    public ResponseEntity<Duenio> getduenioById(@PathVariable String documento) {
        /*
         * Endpoint para obtener un duenio por medio del id.
         * localhost:8080/duenio/getByDocumento/1234
         */
        Duenio duenio = duenioRepository.findDuenioByDocumento(documento);
        if (duenio != duenioRepository) {

            return ResponseEntity.ok(duenio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAllDuenios")
    public ResponseEntity<List<Duenio>> getAllDuenios() {
        /*
         * Nos devuelve todos los datos que contiene la tabla duenios.
         */
        return ResponseEntity.ok(duenioRepository.findAll());
    }

}
