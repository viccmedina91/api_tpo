package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Imagen;
import com.example.demo.exceptions.ReclamoException;
import com.example.demo.views.NuevoEstado;
import com.example.demo.views.NuevoReclamo;
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
            return ResponseEntity.status(HttpStatus.OK)
                    .body("{\"mensaje\": \"" + "Error, El codigo edificio no existe: " + codigoEdificio + "\"}");
        }
        return ResponseEntity.ok(reclamos);
    }

    @GetMapping("/unidad/{id}")
    public ResponseEntity<?> obtenerReclamosPorUnidad(@PathVariable("id") int codigoUnidad) {
        // Dado un codigo de unidad, devolvemos todos los reclamos asociados
        List<ReclamoView> reclamos = this.controlador.reclamosPorUnidad(codigoUnidad);
        if (reclamos == null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("{\"mensaje\": \"" + "Error, El codigo unidad no existe: " + codigoUnidad + "\"}");
        }
        return ResponseEntity.ok(reclamos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerReclamoPorId(@PathVariable Integer id) throws ReclamoException {
        // Dado un numero de reclamo, lo devolvemos
        ReclamoView reclamo = controlador.reclamosPorNumero(id);
        if (reclamo == null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("{\"mensaje\": \"" + "Error, El codigo reclamo no existe: " + id + "\"}");
        }
        return ResponseEntity.ok(reclamo);
    }

    @GetMapping("/personas/{documento}")
    public ResponseEntity<?> reclamosPorDni(@PathVariable String documento) {
        List<ReclamoView> reclamos = this.controlador.reclamosPorPersona(documento);
        if (reclamos == null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("{\"mensaje\": \"" + "Error, El documento ingresado no existe: " + documento + "\"}");

        }
        return ResponseEntity.ok(reclamos);
    }

    @PostMapping()
    public ResponseEntity<?> guardarReclamo(@RequestBody NuevoReclamo reclamo) throws ReclamoException {
        // Para guardar un reclamo en la base de datos
        String operacion = this.controlador.agregarReclamo(reclamo);

        return ResponseEntity.status(HttpStatus.OK)
                .body("{\"mensaje\": \"" + operacion + "\"}");
    }

    @PutMapping("/agregar/imagen/{reclamo}")
    public ResponseEntity<?> agregarImagen(@PathVariable("reclamo") int idReclamo,
            @RequestHeader(value = "Otro-Encabezado", required = false) String documento,
            @RequestBody Imagen imagenes)
            throws ReclamoException {
        // Dado un reclamo existente, almacenamos las imagenes

        System.out.println("DOCUMENTOO --> " + documento);
        String operacion = this.controlador.agregarImagenAReclamo(idReclamo, documento, imagenes);

        return ResponseEntity.status(HttpStatus.OK)
                .body("{\"mensaje\": \"" + operacion + "\"}");

    }

    @PutMapping("/cambiar/estado")
    public ResponseEntity<?> cambiarEstado(@RequestBody NuevoEstado nuevoEstado) throws ReclamoException {
        String operacion = this.controlador.cambiarEstado(nuevoEstado);

        return ResponseEntity.status(HttpStatus.OK)
                .body("{\"mensaje\": \"" + operacion + "\"}");

    }
}
