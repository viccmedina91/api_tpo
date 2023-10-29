package com.example.demo.controller;

import java.util.Map;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Imagen;
import com.example.demo.entity.Reclamo;
import com.example.demo.requests.AltaImagenRequest;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/imagenes", produces = "application/json")
public class ImagenController {
    private final ImagenRepository imagenRepository;
    private final ReclamoRepository reclamoRepository;

    @Autowired
    public ImagenController(ImagenRepository imagenRepository,
            ReclamoRepository reclamoRepository) {
        this.imagenRepository = imagenRepository;
        this.reclamoRepository = reclamoRepository;
    }

    @PostMapping("/crear")
    // Agrega una imagen a u reclamo y a la BD
    public ResponseEntity<Map<String, String>> agregarImagen(@RequestBody AltaImagenRequest rImagen) {
        // Para agregar una imagen a un reclamo existente
        System.out.println("ID RECLAMO " + rImagen.getReclamoid());
        System.out.println("PATH " + rImagen.getPath());
        System.out.println("TIPO " + rImagen.getTipo());
        Reclamo reclamo = this.reclamoRepository.buscarPorID(rImagen.getReclamoid());

        if (reclamo == null) {
            return ResponseEntity.ok(Collections.singletonMap("error", "El Reclamo no existe"));
        }
        Imagen imagen = new Imagen();
        imagen.setReclamo(reclamo);
        imagen.setPath(rImagen.getPath());
        imagen.setTipo(rImagen.getTipo());
        this.imagenRepository.save(imagen);
        return ResponseEntity.ok(Collections.singletonMap("ok", "La imagen ha sido agregada"));

    }

    @GetMapping("/listar")
    // Listamos todas las imagenes almacenadas
    public String getAllImagenes() {
        return this.imagenRepository.findAll().toString();
    }

    @GetMapping("/listar/reclamo/{reclamoid}")
    // Dado un nro de reclamo, devolvemos todas las imagenes asociadas
    public ResponseEntity<Map<String, String>> listarImagenesSegunReclamo(@PathVariable Integer reclamoid) {
        if (this.reclamoRepository.buscarPorID(reclamoid) == null) {
            return ResponseEntity.ok(Collections.singletonMap("error", "El nro de reclamo no existe"));
        }
        return ResponseEntity
                .ok(Collections.singletonMap("ok", this.imagenRepository.imagenesSegunReclamo(reclamoid).toString()));
    }

}
