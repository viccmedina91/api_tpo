package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.exceptions.EdificioException;
import com.example.demo.views.PersonaView;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/unidad", produces = "application/json")
public class UnidadController {
    private final Controlador controlador;

    @Autowired
    public UnidadController(Controlador controlador) {
        this.controlador = controlador;
    }

    @GetMapping("/duenios/{id}")
    public ResponseEntity<?> obtenerDuenios(@PathVariable int id) throws EdificioException {
        // Dado un codigo de unidad, devuelve los dueños asociados
        List<PersonaView> duenios = this.controlador.dueniosPorUnidad(id);
        if (duenios == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La unidad no existe: " + id);
        }
        return ResponseEntity.ok(controlador.dueniosPorUnidad(id));
    }

}
