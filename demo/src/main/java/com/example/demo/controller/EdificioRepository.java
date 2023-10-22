package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Edificio;
import com.example.demo.entity.Unidad;

public interface EdificioRepository extends JpaRepository<Edificio, String> {
    Edificio findByCodigo(Integer codigo);

    public default List<String> listarUnidades(Integer codigoedificio, List<Unidad> unidades) {
        List<String> pertenece = new ArrayList<String>();
        for (Unidad unidad : unidades) {
            if (unidad.getEdificio().getCodigo() == codigoedificio) {
                pertenece.add(unidad.toString());
            }
        }
        return pertenece;

    }
}