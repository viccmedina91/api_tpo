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

import com.example.demo.exceptions.EdificioException;
import com.example.demo.views.EdificioConUnidadesView;
import com.example.demo.views.EdificioView;
import com.example.demo.views.UnidadView;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/edificio", produces = "application/json")
public class EdificioController {
    private final Controlador controlador;

    @Autowired
    public EdificioController(Controlador controlador) {
        this.controlador = controlador;
    }

    @GetMapping("/listar")
    public List<EdificioView> edificioListar() {
        // Devuelve el listado de edificios
        return this.controlador.getEdificios();
    }

    @GetMapping("/con/unidades")
    public List<EdificioConUnidadesView> edificioConUnidades() {
        // Devuelve todos las unidades por edificio
        return this.controlador.getEdificiosConUnidades();
    }

    @GetMapping("/unidades/{id}")
    public ResponseEntity<?> obtenerUnidadesPorEdificio(@PathVariable("id") Integer codigo) throws EdificioException {
        // Dado un codigo de edificio, nos devuelve todas las unidades asociadas.
        List<UnidadView> unidades = this.controlador.getUnidadesPorEdificio(codigo);
        if (unidades == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Edificio no encontrado con el código: " + codigo);
        }
        return ResponseEntity.ok(unidades);
    }

    /*
     * @PostMapping("/crear")
     * public ResponseEntity<String> createEdificio(@RequestBody Edificio edificio)
     * {
     * 
     * Endpoint para la creación de edificio.
     * Por el momento se espera recibir un JSON como el siguiente:
     * {
     * "nombre": "Los Arrayanes",
     * "direccion": "Calle Falsa 1234"
     * }
     * 
     * Edificio edificioSaved = edificioRepository.save(edificio);
     * return ResponseEntity.accepted().body("200 OK - Edificio almacenado: " +
     * edificioSaved.toString());
     * }
     * 
     * @GetMapping("/getByCodigo/{codigoedificio}")
     * public ResponseEntity<Edificio> getEdificioByCodigo(@PathVariable Integer
     * codigoedificio) {
     * 
     * Edificio edificioRecovery = edificioRepository.findByCodigo(codigoedificio);
     * 
     * if (edificioRecovery != null) {
     * return ResponseEntity.ok(edificioRecovery);
     * } else {
     * return ResponseEntity.notFound().build();
     * }
     * }
     * 
     * 
     * 
     * 
     */

}
