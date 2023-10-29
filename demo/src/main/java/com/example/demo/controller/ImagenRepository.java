package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Imagen;

public interface ImagenRepository extends JpaRepository<Imagen, String> {
    public default List<String> imagenesSegunReclamo(Integer reclamoid) {
        List<Imagen> imagenes = findAll();
        List<String> resultado = new ArrayList<String>();
        for (Imagen imagen : imagenes) {
            if (imagen.getReclamo().getIdReclamo() == reclamoid) {
                resultado.add(imagen.toString());
            }
        }
        return resultado;
    }

}
