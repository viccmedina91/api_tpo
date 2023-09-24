package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Edificio;
import com.example.demo.entity.Unidad;

@RestController
public class EdificioController {
    private final EdificioRepository edificioRepository;

    @Autowired
    public EdificioController(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    @PostMapping("/edificio/crear")
    public ResponseEntity<String> createEdificio(@RequestBody Edificio edificio) {
        /*
         * Endpoint para la creación de edificio.
         * Por el momento se espera recibir un JSON como el siguiente:
         * {
         * "nombre": "Los Arrayanes",
         * "direccion": "Calle Falsa 1234"
         * }
         */
        Edificio edificioSaved = edificioRepository.save(edificio);
        return ResponseEntity.accepted().body("200 OK - Edificio almacenado: " +
                edificioSaved.toString());
    }

    @GetMapping("/edificio/getByCodigo/{codigoedificio}")
    public ResponseEntity<Edificio> getEdificioByCodigo(@PathVariable Integer codigoedificio) {
        /*
         * Endpoint para obtener un edificio por medio del codigo.
         * localhost:8080/edificioByCodigo/1234
         */
        Edificio edificioRecovery = edificioRepository.findByCodigo(codigoedificio);

        if (edificioRecovery != null) {
            return ResponseEntity.ok(edificioRecovery);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/edificio/getAllEdificios")
    public ResponseEntity<String> getAllEdificios() throws Exception {
        List<Edificio> edificios = edificioRepository.findAll();
        if (edificios.isEmpty()) {
            throw new Exception("No se encontraron edificios en la base de datos.");
        }
        return ResponseEntity.ok(edificios.toString());
    }

    @GetMapping("/edificio/getUnidades/{codigoedificio}")
    public ResponseEntity<String> getUnidades(@PathVariable Integer codigoedificio) {
        // Comprobamos que el edificio exista
        Edificio edificioRecovery = edificioRepository.findByCodigo(codigoedificio);
        if (edificioRecovery == null) {
            return null;
        }
        // System.out.println("unidades: " + edificioRecovery.getUnidades());
        List<Unidad> unidades = edificioRecovery.getUnidades();
        return ResponseEntity.ok(unidades.toString());

        // Si el edificio existe, recuperamos todas las unidades
    }

}
