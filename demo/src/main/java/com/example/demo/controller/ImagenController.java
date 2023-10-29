package com.example.demo.controller;

import java.util.Map;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Imagen;
import com.example.demo.entity.Reclamo;

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
    public ResponseEntity<Map<String, String>> agregarImagen(@RequestBody AltaImagenRequest rImagen) {
        // Para agregar una imagen a un reclamo existente
        Reclamo reclamo = this.reclamoRepository.buscarPorID(rImagen.getNroRelcamo());
        if (reclamo == null) {
            return ResponseEntity.ok(Collections.singletonMap("error", "El Reclamo no existe"));
        }
        Imagen imagen = new Imagen();
        imagen.setReclamo(reclamo);
        imagen.setPath(rImagen.getPathImagen());
        imagen.setTipo(rImagen.getTipo());
        return ResponseEntity.ok(Collections.singletonMap("ok", "La imagen ha sido agregada"));

    }

    @GetMapping("/listar")
    public String getAllImagenes() {
        return this.imagenRepository.findAll().toString();
    }

}
