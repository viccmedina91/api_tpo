package com.example.demo.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Edificio;
import com.example.demo.exceptions.EdificioException;
import com.example.demo.views.EdificioConUnidadesView;
import com.example.demo.views.EdificioView;
import com.example.demo.views.PersonaView;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEdificioPorId(@PathVariable Integer id) throws EdificioException {
        EdificioView edificio = this.controlador.buscarEdificioPorCodigo(id);
        if (edificio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La unidad no existe: " + id);
        }
        return ResponseEntity.ok(edificio);
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

    @GetMapping("/duenios/{id}")
    public ResponseEntity<?> obtenerDueniosPorEdificio(@PathVariable("id") int codigo) throws EdificioException {
        // Dado un codigo de edificio, devolvemos todos los dueños
        List<PersonaView> duenios = this.controlador.dueniosPorEdificio(codigo);
        if (duenios == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Edificio no encontrado con el código: " + codigo);
        }
        return ResponseEntity.ok(duenios);

    }

    @PostMapping()
    public ResponseEntity<?> guardarEdificio(@RequestBody Edificio edificio) {
        // Guardar un Edificio
        // Campos: Nombre (String), Direccion (String)
        return ResponseEntity.status(HttpStatus.CREATED).body(this.controlador.guardarEdificio(edificio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEdificio(@PathVariable int id, @RequestBody Edificio edificio) {
        // Actualizar un edificio
        EdificioView edificioActualizado = this.controlador.actualizarEdificio(edificio, id);
        if (edificioActualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Edificio no encontrado con el código: " + id);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(edificioActualizado);
    }

    @GetMapping("/habitantes/{id}")
    public ResponseEntity<?> obtenerHabitantesPorEdificio(@PathVariable("id") int codigo) throws EdificioException {
        // Dado un codigo de unidad, devolvemos los habitantes
        List<PersonaView> habitantes = this.controlador.habitantesPorEdificio(codigo);
        if (habitantes == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Edificio no encontrado con el código: " + codigo);
        }
        return ResponseEntity.ok(habitantes);
    }

    @GetMapping("/habilitados/{id}")
    public ResponseEntity<?> obtenerHabilitadosPorEdificio(@PathVariable("id") int codigo) throws EdificioException {
        // Dado un codigo de edificio, nos devuelve los habilitados
        List<PersonaView> habilitados = this.controlador.habilitadosPorEdificio(codigo);
        if (habilitados == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Edificio no encontrado con el código: " + codigo);
        }
        return ResponseEntity.ok(habilitados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEdificioPorId(@PathVariable(value = "id") Integer edificio) {
        // Dado un codigo de edificio, se elimina
        EdificioView eliminado = this.controlador.eliminarEdificio(edificio);
        if (eliminado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error, no se ha podido eliminar el Edificio: " + edificio);

        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
