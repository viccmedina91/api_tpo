package com.example.demo.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Duenio;
import com.example.demo.repository.DuenioRepository;

@RestController
public class DuenioController {
    private final DuenioRepository duenioRepository;

    @Autowired
    public DuenioController(DuenioRepository duenioRepository) {
        this.duenioRepository = duenioRepository;
    }

    @PostMapping("/createDuenio")
    public String createDuenio(@RequestBody Duenio duenio) {
        /*
         * Enpoint para crear un duenio. Se debe enviar lo siguiente
         * {
         * "identificador": 9999,
         * "documento": "DNI12344"
         * }
         */
        Duenio duenioGuardada = duenioRepository.save(duenio);
        return "Nuevo duenio almacenado: " + duenioGuardada.getId();
    }

    @GetMapping("/getDuenioById/{id}")
    public ResponseEntity<Duenio> getduenioById(@PathVariable Integer id) {
        /*
         * Endpoint para obtener un duenio por medio del id.
         * localhost:8080/getDuenioById/1234
         */
        Optional<Duenio> duenioOptional = duenioRepository.findById(id);
        if (duenioOptional.isPresent()) {
            Duenio duenio = duenioOptional.get();
            return ResponseEntity.ok(duenio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
