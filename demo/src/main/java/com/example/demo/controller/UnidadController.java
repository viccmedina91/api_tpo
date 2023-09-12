package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Unidad;
import com.example.demo.repository.UnidadRepository;

@RestController
public class UnidadController {
    private final UnidadRepository unidadRepository;

    @Autowired
    public UnidadController(UnidadRepository unidadRepository) {
        this.unidadRepository = unidadRepository;
    }

    @PostMapping("/createUnidad")
    public String createUnidad(@RequestBody Unidad unidad) {
        /*
         * Enpoint para crear una unidad. Se debe enviar lo siguiente
         * {
         * "identificador": 9999,
         * "piso": 1,
         * "numero": 999,
         * "habitado": "N"
         * }
         */
        Unidad unidadGuardada = unidadRepository.save(unidad);
        return "Unidad Guardada: " + unidadGuardada.getIdentificador();
    }

    @GetMapping("/getUnidadByIdentificador/{identificador}")
    public ResponseEntity<Unidad> getUnidadByIdentificador(@PathVariable Integer identificador) {
        /*
         * Endpoint para obtener una unidad por medio del identificador.
         * localhost:8080/getUnidadByIdentificador/1234
         */
        Optional<Unidad> unidadOptional = unidadRepository.findByIdentificador(identificador);
        if (unidadOptional.isPresent()) {
            Unidad unidad = unidadOptional.get();
            return ResponseEntity.ok(unidad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/allUnitByEdificios/{identificador}")
    public ResponseEntity<List<Unidad>> getUnidadesByEdificio(@PathVariable Integer identificador) {
        /*
         * Endpoint para obtener una unidad por medio del identificador.
         * localhost:8080/allUnitByEdificios/1234
         */

        List<Unidad> unidades = unidadRepository.findByEdificioCodigo(identificador);
        return ResponseEntity.ok(unidades);
    }
}
