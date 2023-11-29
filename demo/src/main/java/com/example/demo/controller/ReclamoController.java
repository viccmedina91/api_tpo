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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Imagen;
import com.example.demo.entity.Reclamo;
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
                    .body("{\"mensaje\": \"" + "El codigo edificio no existe: " + codigoEdificio + "\"}");
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

    @GetMapping("/personas/{documento}")
    public ResponseEntity<?> reclamosPorDni(@PathVariable String documento) {
        List<ReclamoView> reclamos = this.controlador.reclamosPorPersona(documento);
        if (reclamos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La persona no existe: " + documento);

        }
        return ResponseEntity.ok(reclamos);
    }

    @PostMapping()
    public ResponseEntity<?> guardarReclamo(@RequestBody NuevoReclamo reclamo) throws ReclamoException {
        // Para guardar un reclamo en la base de datos
        return ResponseEntity.status(HttpStatus.CREATED).body(controlador.agregarReclamo(reclamo));
    }

    @PutMapping("/agregar/imagen/{reclamo}")
    public ResponseEntity<?> agregarImagen(@PathVariable("reclamo") int idReclamo, @RequestBody List<Imagen> imagenes)
            throws ReclamoException {
        // Dado un reclamo existente, almacenamos las imagenes
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.controlador.agregarImagenAReclamo(idReclamo, imagenes));
    }

    @PutMapping("/cambiar/estado")
    public ResponseEntity<?> cambiarEstado(@RequestBody NuevoEstado nuevoEstado) throws ReclamoException {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.controlador.cambiarEstado(nuevoEstado));
    }
}
