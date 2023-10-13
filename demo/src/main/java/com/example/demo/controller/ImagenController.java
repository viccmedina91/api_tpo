package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Imagen;

@RestController
public class ImagenController {
    private final ImagenRepository imagenRepository;

    @Autowired
    public ImagenController(ImagenRepository imagenRepository) {
        this.imagenRepository = imagenRepository;
    }

    @GetMapping("/imagen/getAllImagenes")
    public String getAllImagenes() {
        return imagenRepository.findAll().toString();
    }

}
