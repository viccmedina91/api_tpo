package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/estado", produces = "application/json")
public class EstadoController {
    private final EstadoRepository estadoRepository;

    @Autowired
    public EstadoController(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<String>> listarTodos() {
        /*
         * Nos devuelve todos los datos que contiene la tabla duenios.
         */
        return ResponseEntity.ok(this.estadoRepository.listarTodos());
    }
}
