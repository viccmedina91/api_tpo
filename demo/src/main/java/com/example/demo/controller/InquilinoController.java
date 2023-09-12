package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Inquilino;
import com.example.demo.repository.InquilinoRepository;

@RestController
public class InquilinoController {
    private final InquilinoRepository inquilinoRepository;

    @Autowired
    public InquilinoController(InquilinoRepository inquilinoRepository) {
        this.inquilinoRepository = inquilinoRepository;
    }

    @PostMapping("/createInquilino")
    public String createInquilino(@RequestBody Inquilino inquilino) {
        /*
         * Enpoint para crear un inquilino. Se debe enviar lo siguiente
         * {
         * "identificador": 9999,
         * "documento": "DNI121212"
         * }
         */
        Inquilino inquilinoGuardado = inquilinoRepository.save(inquilino);
        return "Inquilino Almacenado: " + inquilinoGuardado.getIdentificador();
    }

    @GetMapping("/getInquilinoByDocumento/{documento}")
    public ResponseEntity<List<Inquilino>> getInquilinoByDocumento(@PathVariable String documento) {
        /*
         * Endpoint para obtener un unidad por medio del documento.
         * localhost:8080/getUnidadByDocumento/1234
         */
        List<Inquilino> inquilinos = inquilinoRepository.findAllByDocumento(documento);
        return ResponseEntity.ok(inquilinos);
    }

    @GetMapping("/getAllInquilinos")
    public ResponseEntity<List<Inquilino>> getAllInquilinos() {
        return ResponseEntity.ok(inquilinoRepository.findAll());

    }
}
