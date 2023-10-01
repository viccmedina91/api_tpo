package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Duenio;
import com.example.demo.entity.Edificio;
import com.example.demo.entity.Unidad;

public interface EdificioRepository extends JpaRepository<Edificio, String> {
    Edificio findByCodigo(Integer codigo);

    public default String dueniosByEdificio(Integer codigo) {
        Edificio edificioRecovery = findByCodigo(codigo);
        List<Duenio> duenios = new ArrayList<>();
        List<Unidad> unidades = edificioRecovery.getUnidades();
        for (Unidad unidad : unidades) {
            duenios.add(unidad.getDuenio());
        }

        return duenios.toString();
    }
}