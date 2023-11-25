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

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/imagenes", produces = "application/json")
public class ImagenController {
    private final ReclamoRepository reclamoRepository;

    @Autowired
    public ImagenController(
            ReclamoRepository reclamoRepository) {
        this.reclamoRepository = reclamoRepository;
    }

}
