package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Reclamo;
import com.example.demo.repository.ReclamoRepository;

@RestController
public class ReclamoController {
    private final ReclamoRepository reclamoRepository;

    @Autowired
    public ReclamoController(ReclamoRepository reclamoRepository) {
        this.reclamoRepository = reclamoRepository;
    }

    @GetMapping("/getReclamoById/{idReclamo}")
    public String getReclamoById(@RequestBody Reclamo reclamo) {
        Reclamo reclamoNuevo = reclamoRepository.save(reclamo);
        return "Nuevo reclamo almacenado: " + reclamoNuevo.toString();
    }

    @PostMapping("/createReclamo")
    public String createReclamo(@RequestBody Reclamo reclamo) {
        System.out.println("1111111111111111");
        System.out.println(reclamo.getDescripcion());
        return "Nuvo Reclamo: ";
    }
}
