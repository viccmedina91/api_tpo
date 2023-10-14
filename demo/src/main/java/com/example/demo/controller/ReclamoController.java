package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Reclamo;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/reclamo", produces = "application/json")
public class ReclamoController {
    private final ReclamoRepository reclamoRepository;

    @Autowired
    public ReclamoController(ReclamoRepository reclamoRepository) {
        this.reclamoRepository = reclamoRepository;
    }

    @GetMapping("/getAllReclamos")
    public ResponseEntity<List<Reclamo>> getAllReclamos() {
        List<Reclamo> reclamos = reclamoRepository.findAll();
        return ResponseEntity.ok(reclamos);
    }

}
