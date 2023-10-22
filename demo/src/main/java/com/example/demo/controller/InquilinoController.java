package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Inquilino;
import com.example.demo.entity.Persona;
import com.example.demo.entity.Unidad;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/inquilino", produces = "application/json")
public class InquilinoController {
    private final InquilinoRepository inquiniloRepository;
    private final UnidadRepository unidadRepository;
    private final PersonaRepository personaRepository;

    @Autowired
    public InquilinoController(
            InquilinoRepository inquiniloRepository,
            PersonaRepository personaRepository,
            UnidadRepository unidadRepository) {
        this.inquiniloRepository = inquiniloRepository;
        this.personaRepository = personaRepository;
        this.unidadRepository = unidadRepository;
    }

    @GetMapping("/getAllInquilinos")
    public ResponseEntity<List<Inquilino>> getAllInquilinos() {
        /*
         * Nos devuelve todos los datos que contiene la tabla personas.
         */
        return ResponseEntity.ok(inquiniloRepository.findAll());
    }

    @GetMapping("/getInquilinos/edificio/{codigoedificio}")
    public ResponseEntity<List<Inquilino>> getInquilinoPorEdificio(@PathVariable Integer codigoedificio) {
        // Inquilinos por código de Edificio
        List<Inquilino> inquilinos = inquiniloRepository.findInquilinosPorEdificio(codigoedificio);
        return ResponseEntity.ok(inquilinos);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> createInquilino(@RequestBody AltaDuenioRequest rDuenio) {
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

        Inquilino inquilino = new Inquilino();
        inquilino.setPersona(persona);
        inquilino.setUnidad(unidad);
        inquiniloRepository.save(inquilino);
        return ResponseEntity.accepted().body("200 OK - Nuevo Inquilino alamcenado");
    }
}
