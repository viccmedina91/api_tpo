package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, String> {
    public default List<String> listarTodos() {
        List<String> resultados = new ArrayList<String>();
        List<Estado> estados = findAll();
        for (Estado estado : estados) {
            resultados.add(estado.toString());
        }
        return resultados;
    }

    public default Estado encontrarPorDescripcion(String descripcion) {
        List<Estado> estados = findAll();
        for (Estado estado : estados) {
            if (descripcion.equals(estado.getDescripcion())) {
                return estado;
            }
        }
        return null;
    }

}
