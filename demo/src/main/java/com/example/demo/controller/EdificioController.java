package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Edificio;
import com.example.demo.repository.EdificioRepository;

@RestController
public class EdificioController {
    private final EdificioRepository edificioRepository;

    @Autowired
    public EdificioController(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    @PostMapping("/createEdificio")
    public String createEdificio(@RequestBody Edificio edificio) {
        /*
         * Endpoint para la creación de edificio.
         * Por el momento se espera recibir un JSON como el siguiente:
         * {
         * "codigo": 1234,
         * "nombre": "Los Arrayanes",
         * "direccion": "Calle Falsa 1234"
         * }
         */
        Edificio edificioGuardada = edificioRepository.save(edificio);
        return "Edificio Guardado: " + edificioGuardada.getNombre();
    }

    @GetMapping("/getEdificioByCodigo/{codigo}")
    public ResponseEntity<Edificio> getEdificioByCodigo(@PathVariable Integer codigo) {
        /*
         * Endpoint para obtener un edificio por medio del codigo.
         * localhost:8080/edificioByCodigo/1234
         */
        Optional<Edificio> edificioOptional = edificioRepository.findByCodigo(codigo);

        if (edificioOptional.isPresent()) {
            Edificio edificio = edificioOptional.get();
            return ResponseEntity.ok(edificio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
