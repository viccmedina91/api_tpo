package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Edificio;
import com.example.demo.entity.Persona;
import com.example.demo.entity.Reclamo;
import com.example.demo.entity.Unidad;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/reclamo", produces = "application/json")
public class ReclamoController {
    private final ReclamoRepository reclamoRepository;
    private final EdificioRepository edificioRepository;
    private final PersonaRepository personaRepository;
    private final UnidadRepository unidadRepository;

    @Autowired
    public ReclamoController(ReclamoRepository reclamoRepository,
            EdificioRepository edificioRepository,
            PersonaRepository personaRepository,
            UnidadRepository unidadRepository) {
        this.reclamoRepository = reclamoRepository;
        this.edificioRepository = edificioRepository;
        this.personaRepository = personaRepository;
        this.unidadRepository = unidadRepository;
    }

    @GetMapping("/getAllReclamos")
    public ResponseEntity<List<Reclamo>> getAllReclamos() {
        // Retorna todos los reclamos cargados
        List<Reclamo> reclamos = reclamoRepository.findAll();
        return ResponseEntity.ok(reclamos);
    }

    @GetMapping("/getReclamosPorEdificio/{codigoedificio}")
    public ResponseEntity<List<Reclamo>> getReclamosPorEdificio(@PathVariable Integer codigoedificio) {
        // Dado un código de Edificio, devolvemos el listado de reclamos asociados
        List<Reclamo> reclamos = reclamoRepository.findReclamoPorEdificio(codigoedificio);
        return ResponseEntity.ok(reclamos);
    }

    @GetMapping("/getReclamosPorUnidad/{codigoedificio}")
    public ResponseEntity<List<Reclamo>> getReclamosPorUnidad(@PathVariable Integer codigoedificio) {
        // Dado un código de Unidad, devolvemos el listado de reclamos asociados
        List<Reclamo> reclamos = reclamoRepository.findReclamoPorUnidad(codigoedificio);
        return ResponseEntity.ok(reclamos);
    }

    @GetMapping("/getReclamosPorPersona/{documento}")
    public ResponseEntity<List<Reclamo>> getReclamosPorPersona(@PathVariable String documento) {
        // Dado un código de Unidad, devolvemos el listado de reclamos asociados
        List<Reclamo> reclamos = reclamoRepository.findReclamoPorPersona(documento);
        return ResponseEntity.ok(reclamos);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> addReclamo(@RequestBody AltaReclamoRequest rReclamo) {
        // Endpoint para crear un reclamo.

        Edificio edificio = edificioRepository.findByCodigo(rReclamo.getCodigo());
        if (edificio == null) {
            return new ResponseEntity<>("El codigo de edificio no existe", HttpStatus.BAD_REQUEST);
        }
        Persona persona = personaRepository.findByDocumento(rReclamo.getDocumento());
        if (persona == null) {
            return new ResponseEntity<>("El documento no se encuentra registrado", HttpStatus.BAD_REQUEST);
        }
        Unidad unidad = unidadRepository.findUnidadByIdentificador(rReclamo.getIdentificador());
        if (unidad == null) {
            return new ResponseEntity<>("El codigo de unidad no existe", HttpStatus.BAD_REQUEST);

        }
        Reclamo reclamo = new Reclamo();
        reclamo.setPersona(persona);
        reclamo.setEdificio(edificio);
        reclamo.setUnidad(unidad);
        reclamo.setDescripcion(rReclamo.getDescripcion());
        reclamo.setUbicacion(rReclamo.getUbicacion());
        reclamoRepository.save(reclamo);
        return new ResponseEntity<>("Reclamo creado exitosamente", HttpStatus.CREATED);

    }

}
