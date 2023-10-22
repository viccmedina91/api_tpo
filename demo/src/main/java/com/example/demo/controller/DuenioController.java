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
    public ResponseEntity<String> createDuenio(@RequestBody AltaDuenioRequest rDuenio) {
        // Endpoint para dar de alta un nuevo duenio.

        Unidad unidad = unidadRepository.findUnidadByIdentificador(rDuenio.getIdentificador());
        // Si la unidad no existe, no se podrá crear un nuevo dienio
        if (unidad == null) {
            System.out.println("La unidad ingresada no existe");
            return ResponseEntity.accepted().body("La unidad ingresada no existe");
        }

        Persona persona = personaRepository.findByDocumento(rDuenio.getDocumento());
        // Si la persona no se encuentra registrada, la registramos
        if (persona == null) {
            Persona nuevaPersona = new Persona();
            nuevaPersona.setContrasenia(rDuenio.getContrasenia());
            nuevaPersona.setDocumento(rDuenio.getDocumento());
            nuevaPersona.setMail(rDuenio.getMail());
            nuevaPersona.setNombre(rDuenio.getNombre());
            personaRepository.save(nuevaPersona);
            System.out.println("La persona no existia, pero la hemos agregado");
            personaRepository.save(persona);
        }

        // verificamos que la unidad ingresada exista

        Duenio duenio = new Duenio();
        duenio.setPersona(persona);
        duenio.setUnidad(unidad);
        duenioRepository.save(duenio);
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
    public ResponseEntity<List<String>> getAllDuenios() {
        /*
         * Nos devuelve todos los datos que contiene la tabla duenios.
         */
        return ResponseEntity.ok(duenioRepository.listarTodos(duenioRepository.findAll()));
    }

}
