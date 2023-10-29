package com.example.demo.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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
import com.example.demo.requests.AltaDuenioRequest;

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

    @GetMapping("/listar")
    public ResponseEntity<List<String>> listarTodos() {
        /*
         * Nos devuelve todos los datos que contiene la tabla personas.
         */
        List<String> inquilinos = inquiniloRepository.listarTodos();
        return ResponseEntity.ok(inquilinos);
    }

    @GetMapping("/getInquilinos/edificio/{codigoedificio}")
    public ResponseEntity<List<Inquilino>> getInquilinoPorEdificio(@PathVariable Integer codigoedificio) {
        // Inquilinos por código de Edificio
        List<Inquilino> inquilinos = inquiniloRepository.findInquilinosPorEdificio(codigoedificio);
        return ResponseEntity.ok(inquilinos);
    }

    @PostMapping("/crear")
    public ResponseEntity<Map<String, String>> createInquilino(@RequestBody AltaDuenioRequest rDuenio) {
        // Endpoint para dar de alta un nuevo duenio.
        Inquilino inquilino = new Inquilino();
        Unidad unidad = this.unidadRepository.findUnidadByIdentificador(rDuenio.getIdentificador());
        // Si la unidad no existe, no se podrá crear un nuevo dienio
        if (unidad == null) {
            System.out.println("La unidad ingresada no existe");
            return ResponseEntity.ok(Collections.singletonMap("error", "La unidad no existe"));
        }
        if (this.inquiniloRepository.existeInquilino(rDuenio.getDocumento())) {
            return ResponseEntity.ok(Collections.singletonMap("error", "La persona ya es inquilino"));

        }

        Persona persona = personaRepository.findByDocumento(rDuenio.getDocumento());
        // Si la persona no se encuentra registrada, la registramos
        if (persona == null) {
            Persona nuevaPersona = new Persona();
            nuevaPersona.setContrasenia(rDuenio.getContrasenia());
            nuevaPersona.setDocumento(rDuenio.getDocumento());
            nuevaPersona.setMail(rDuenio.getMail());
            nuevaPersona.setNombre(rDuenio.getNombre());
            this.personaRepository.save(nuevaPersona);
            inquilino.setPersona(nuevaPersona);
        } else {
            inquilino.setPersona(persona);
        }

        inquilino.setUnidad(unidad);
        this.inquiniloRepository.save(inquilino);
        unidad.setHabitado("S");
        this.unidadRepository.save(unidad);
        return ResponseEntity.ok(Collections.singletonMap("ok", "Inquilino guardado"));
    }
}
