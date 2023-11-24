package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Edificio;
import com.example.demo.entity.Unidad;
import com.example.demo.entity.UnidadPersona;
import com.example.demo.exceptions.EdificioException;
import com.example.demo.views.EdificioView;
import com.example.demo.views.PersonaView;
import com.example.demo.views.UnidadView;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/unidad", produces = "application/json")
public class UnidadController {
    private final Controlador controlador;

    @Autowired
    public UnidadController(Controlador controlador) {
        this.controlador = controlador;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUnidadPorId(@PathVariable Integer id) throws EdificioException {
        UnidadView unidad = this.controlador.buscarUnidadPorCodigo(id);
        if (unidad == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La unidad no existe: " + id);
        }
        return ResponseEntity.ok(unidad);
    }

    @GetMapping("/duenios/{id}")
    public ResponseEntity<?> obtenerDuenios(@PathVariable int id) throws EdificioException {
        // Dado un codigo de unidad, devuelve los dueños asociados
        List<PersonaView> duenios = this.controlador.dueniosPorUnidad(id);
        if (duenios == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La unidad no existe: " + id);
        }
        return ResponseEntity.ok(duenios);
    }

    @GetMapping("/inquilinos/{id}")
    public ResponseEntity<?> obtenerInquilinos(@PathVariable int id) throws EdificioException {
        // Dado un codigo de unidad, devuelve los inquilinos asociados
        List<PersonaView> inquilinos = this.controlador.inquilinosPorUnidad(id);
        if (inquilinos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La unidad no existe: " + id);
        }
        return ResponseEntity.ok(inquilinos);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> guardarUnidad(@PathVariable int id, @RequestBody Unidad unidad) {
        // Guardar una Unidad
        // Campos: Piso (String), Numero (String), Habitado, Codigo Edificio
        UnidadView unidadNueva = this.controlador.guardarUnidad(unidad, id);
        if (unidadNueva == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Edificio no encontrado con el código: " + id);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(unidadNueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUnidad(@PathVariable int id, @RequestBody Unidad unidad) {
        // Actualizar una unidad
        UnidadView unidadActualizado = this.controlador.actualizarUnidad(unidad, id);
        if (unidadActualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unidad no encontrado con el código: " + id);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(unidadActualizado);
    }

    @PutMapping("/transferir/unidad")
    public ResponseEntity<?> transferirUnidad(@RequestBody UnidadPersona unidadPersona) {
        // Dado un documento de un dueño y el codigo de una unidad, se transfiere

        String operacion = this.controlador.transferirUnidad(unidadPersona);
        return ResponseEntity.status(HttpStatus.CREATED).body(operacion);
    }

    @PostMapping("/agregar/duenio")
    public ResponseEntity<?> agregarDuenio(@RequestBody UnidadPersona unidadPersona) {
        // Dado un documento y un codigo de unidad, le asignamos la propiedad
        PersonaView persona = this.controlador.agregarDuenioUnidad(unidadPersona);
        if (persona == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unidad o Persona inexistente");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(persona);
    }

    @PostMapping("/agregar/inquilino")
    public ResponseEntity<?> agregarInquilino(@RequestBody UnidadPersona unidadPersona) {
        // Dado un documento y un codigo de unidad, agregamos a la persona como
        // inquilino de la misma
        if (this.controlador.agregarInquilinoUnidad(unidadPersona)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(unidadPersona);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ha ocurrido un error");
    }

    @DeleteMapping("/liberar/{id}")
    public ResponseEntity<?> liberarUnidad(@PathVariable int id) {
        // Dado un codigo de unidad, la liberamos
        if (this.controlador.liberarUnidad(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ha ocurrido un error");

        }
        return ResponseEntity.ok().build();

    }

    @PutMapping("/habitar/{id}")
    public ResponseEntity<?> habitarUnidad(@PathVariable int id) {
        // Dado un codigo de unidad, la ponemos como habitada
        if (controlador.habitarUnidad(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ha ocurrido un error");
        }
        return ResponseEntity.ok().build();
    }

}
