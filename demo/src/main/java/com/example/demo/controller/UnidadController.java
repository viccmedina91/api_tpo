package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Edificio;
import com.example.demo.entity.Unidad;
import com.example.demo.requests.AltaUnidadRequest;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/unidad", produces = "application/json")
public class UnidadController {
    private final UnidadRepository unidadRepository;
    private final EdificioRepository edificioRepository;

    @Autowired
    public UnidadController(UnidadRepository unidadRepository,
            EdificioRepository edificioRepository) {
        this.unidadRepository = unidadRepository;
        this.edificioRepository = edificioRepository;
    }

    @PostMapping("/create")
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
        Unidad unidad = new Unidad();
        unidad.setEdificio(edificioRecovery);
        unidad.setHabitado(urquest.getHabitado());
        unidad.setNumero(urquest.getNumero());
        unidad.setPiso(urquest.getPiso());
        unidadRepository.save(unidad);
        return ResponseEntity.accepted().body("200 OK - Nueva unidad agregada");

    }

    @GetMapping("/getbyid/{identificador}")
    public ResponseEntity<Unidad> getUnidadById(@PathVariable Integer identificador) {
        /*
         * Endpoint para obtener una unidad por medio del identificador.
         * localhost:8080/allUnitByEdificios/1234
         */

        Unidad unidadRecovery = unidadRepository.findUnidadByIdentificador(identificador);
        return ResponseEntity.ok(unidadRecovery);
    }

    @GetMapping("/getAllUnidades")
    public ResponseEntity<List<String>> getAllUnidades() {
        // Obtenermos todas las unidades cargadas en el sistema
        List<String> unidades = unidadRepository.listarUnidades(unidadRepository.findAll());
        return ResponseEntity.ok(unidades);
    }

    @GetMapping("/getDuenio/{identificador}")
    public String getDuenio(@PathVariable Integer identificador) {
        // Dado un identificador de unidad, obtenemos el duenio
        Unidad unidadRecovery = unidadRepository.findUnidadByIdentificador(identificador);
        return unidadRecovery.getDuenio().toString();

    }

    /*
     * @PatchMapping("/unidad/alquilarUnidad")
     * public ResponseEntity<String> altaAlquiler(@RequestBody AltaAlquilerRequest
     * urquest) {
     * System.out.println("#######################################################")
     * ;
     * System.out.println("Identificador" +
     * urquest.getIdentificadorUnidad().toString());
     * System.out.println("documento: " + urquest.getDocumento());
     * Unidad unidadRecovery =
     * unidadRepository.findUnidadByIdentificador(urquest.getIdentificadorUnidad());
     * if (unidadRecovery == null) {
     * return ResponseEntity.ok("Unidad inexistente");
     * }
     * if (unidadRecovery.getHabitado() == "S") {
     * return ResponseEntity.ok("La unidad ya se encuentra alquilada");
     * }
     * List<Inquilino> inquilinos = unidadRecovery.getInquilinos();
     * System.out.println(inquilinos.toString());
     * for (Inquilino inquilino : inquilinos) {
     * if (inquilino.getPersona().getDocumento().equals(urquest.getDocumento())) {
     * System.out.println("Inquilino encontrado");
     * unidadRecovery.setHabitado("S");
     * unidadRepository.save(unidadRecovery);
     * return ResponseEntity.ok("Unidad alquilada: " + unidadRecovery.toString());
     * }
     * }
     * return ResponseEntity.ok("Ha ocurrido un error");
     * }
     */
}
