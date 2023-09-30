package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Edificio;
import com.example.demo.entity.Inquilino;
import com.example.demo.entity.Unidad;

@RestController
public class UnidadController {
    private final UnidadRepository unidadRepository;
    private final EdificioRepository edificioRepository;

    @Autowired
    public UnidadController(UnidadRepository unidadRepository,
            EdificioRepository edificioRepository) {
        this.unidadRepository = unidadRepository;
        this.edificioRepository = edificioRepository;
    }

    @PostMapping("/unidad/create")
    public ResponseEntity<String> createUnidad(@RequestBody AltaUnidadRequest urquest) {
        /*
         * identificador: id de la unidad
         * piso: integer donde se encuentra la unidad dentro del edificio
         * numero: identifica a la unidad dentro del piso
         * codigoedificio: FK contra edificio, donde pertenece la unidad
         * habitado: indica si la unidad se encuentra alquilada o no
         */

        // Verificar que el edificio exista
        Edificio edificioRecovery = edificioRepository.findByCodigo(urquest.getCodigoEdificio());
        if (edificioRecovery == null) {
            System.out.println("El codigo de edificio no existe");
            return ResponseEntity.accepted().body("404 Error - El codigo de edificio no existe");
        }
        // Si el edificio existe, se deberá crear la unidad
        System.out.println("El edificio existe");
        Unidad unidad = new Unidad();
        unidad.setEdificio(edificioRecovery);
        unidad.setHabitado(urquest.getHabitado());
        unidad.setNumero(urquest.getNumero());
        unidad.setPiso(urquest.getPiso());
        unidadRepository.save(unidad);
        return ResponseEntity.accepted().body("200 OK - Nueva unidad agregada");

    }

    @GetMapping("/unidad/getbyid/{identificador}")
    public ResponseEntity<Unidad> getUnidadById(@PathVariable Integer identificador) {
        /*
         * Endpoint para obtener una unidad por medio del identificador.
         * localhost:8080/allUnitByEdificios/1234
         */

        Unidad unidadRecovery = unidadRepository.findUnidadByIdentificador(identificador);
        return ResponseEntity.ok(unidadRecovery);
    }

    @GetMapping("/unidad/getAllUnidades")
    public ResponseEntity<List<Unidad>> getAllUnidades(@PathVariable Integer identificador) {
        // Obtenermos todas las unidades cargadas en el sistema
        List<Unidad> unidades = unidadRepository.findAll();
        return ResponseEntity.ok(unidades);
    }

    @GetMapping("unidad/getInquilinos/{identificador}")
    public String getInquilinos(@PathVariable Integer identificador) {
        // Dado el identificador de una unidad, obtenermos la lista de inquilinos
        Unidad unidadRecovery = unidadRepository.findUnidadByIdentificador(identificador);
        List<Inquilino> inquilino = unidadRecovery.getInquilinos();
        return inquilino.toString();

    }

    @GetMapping("unidad/getDuenio/{identificador}")
    public String getDuenio(@PathVariable Integer identificador) {
        // Dado un identificador de unidad, obtenemos el duenio
        System.out.println("#########################");
        System.out.println(identificador.toString());
        Unidad unidadRecovery = unidadRepository.findUnidadByIdentificador(identificador);
        System.out.println("#########################");
        System.out.println(unidadRecovery.getDuenio());
        return null;

    }
}
