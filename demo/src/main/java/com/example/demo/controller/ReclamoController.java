package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.ReclamoException;
import com.example.demo.views.ReclamoView;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/reclamo", produces = "application/json")
public class ReclamoController {
    private final Controlador controlador;

    @Autowired
    public ReclamoController(Controlador controlador) {
        this.controlador = controlador;

    }

    @GetMapping("/edificio/{id}")
    public ResponseEntity<?> obtenerReclamosPorEdificio(@PathVariable("id") int codigoEdificio) {
        // Dado un codigo de edificio, devolvemos todos los reclamos asociados.
        List<ReclamoView> reclamos = this.controlador.reclamosPorEdificio(codigoEdificio);
        if (reclamos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El Edificio no existe: " + codigoEdificio);
        }
        return ResponseEntity.ok(reclamos);
    }

    @GetMapping("/unidad/{id}")
    public ResponseEntity<?> obtenerReclamosPorUnidad(@PathVariable("id") int codigoUnidad) {
        // Dado un codigo de unidad, devolvemos todos los reclamos asociados
        List<ReclamoView> reclamos = this.controlador.reclamosPorUnidad(codigoUnidad);
        if (reclamos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La unidad no existe: " + codigoUnidad);
        }
        return ResponseEntity.ok(reclamos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerReclamoPorId(@PathVariable Integer id) throws ReclamoException {
        // Dado un numero de reclamo, lo devolvemos
        ReclamoView reclamo = controlador.reclamosPorNumero(id);
        if (reclamo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El reclamo no existe: " + id);
        }
        return ResponseEntity.ok(reclamo);
    }

}
