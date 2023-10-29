package com.example.demo.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/listar")
    public ResponseEntity<List<String>> listarTodos() {
        // Retorna todos los reclamos cargados
        List<String> reclamos = reclamoRepository.listarTodos();
        return ResponseEntity.ok(reclamos);
    }

    @GetMapping("/edificio/listar/{codigoedificio}")
    public ResponseEntity<List<String>> listarPorEdificio(@PathVariable Integer codigoedificio) {
        // Dado un código de Edificio, devolvemos el listado de reclamos asociados
        List<String> reclamos = reclamoRepository.listarPorEdificio(codigoedificio);
        return ResponseEntity.ok(reclamos);
    }

    @GetMapping("/unidad/listar/{identificador}")
    public ResponseEntity<List<String>> listarPorUnidad(@PathVariable Integer identificador) {
        // Dado un código de Unidad, devolvemos el listado de reclamos asociados
        List<String> reclamos = reclamoRepository.listarPorUnidad(identificador);
        return ResponseEntity.ok(reclamos);
    }

    @GetMapping("/persona/listar/{documento}")
    public ResponseEntity<List<String>> getReclamosPorPersona(@PathVariable String documento) {
        // Dado un código de Unidad, devolvemos el listado de reclamos asociados
        List<String> reclamos = reclamoRepository.listarPorPersona(documento);
        return ResponseEntity.ok(reclamos);
    }

    @PostMapping("/crear")
    public ResponseEntity<Map<String, String>> addReclamo(@RequestBody AltaReclamoRequest rReclamo) {
        // Endpoint para crear un reclamo.

        Edificio edificio = edificioRepository.findByCodigo(rReclamo.getCodigo());
        if (edificio == null) {
            return ResponseEntity.ok(Collections.singletonMap("error", "El codigo de edificio no existe"));

        }
        Persona persona = personaRepository.findByDocumento(rReclamo.getDocumento());
        if (persona == null) {
            return ResponseEntity.ok(Collections.singletonMap("error", "El documento no se encuentra registrado"));

        }
        Unidad unidad = unidadRepository.findUnidadByIdentificador(rReclamo.getIdentificador());
        if (unidad == null) {
            return ResponseEntity.ok(Collections.singletonMap("error", "El codigo de unidad no existe"));
        }
        Reclamo reclamo = new Reclamo();
        reclamo.setPersona(persona);
        reclamo.setEdificio(edificio);
        reclamo.setUnidad(unidad);
        reclamo.setDescripcion(rReclamo.getDescripcion());
        reclamo.setUbicacion(rReclamo.getUbicacion());
        reclamoRepository.save(reclamo);
        return ResponseEntity.ok(Collections.singletonMap("ok", "Reclamo guardado"));

    }

    @GetMapping("/listar/nro/{identificador}")
    public ResponseEntity<Map<String, String>> listarPorNro(@PathVariable Integer identificador) {
        // Dado un código de Reclamo, lo devolvemos siempre y cuando exista.
        String reclamo = this.reclamoRepository.findById(identificador).toString();
        if (reclamo.contains("empty")) {
            return ResponseEntity.ok(Collections.singletonMap("error", "El nro de reclamo no existe"));
        }
        return ResponseEntity.ok(Collections.singletonMap("ok", reclamo));
    }

}
