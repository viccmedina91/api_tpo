package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.example.demo.entity.Inquilino;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/inquilino", produces = "application/json")
public class InquilinoController {
    private final InquilinoRepository inquiniloRepository;

    @Autowired
    public InquilinoController(InquilinoRepository inquiniloRepository) {
        this.inquiniloRepository = inquiniloRepository;
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
}
