package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Inquilino;

public interface InquilinoRepository extends JpaRepository<Inquilino, String> {

    public default List<Inquilino> findInquilinosPorEdificio(Integer codigoEdificio) {
        List<Inquilino> inquilinos = findAll();
        List<Inquilino> porEdificio = new ArrayList<Inquilino>();
        for (Inquilino inquilino : inquilinos) {
            if (inquilino.getUnidad().getEdificio().getCodigo() == codigoEdificio) {
                porEdificio.add(inquilino);
            }
        }
        return porEdificio;

    }

    public default List<String> listarTodos() {
        List<String> resultado = new ArrayList<String>();
        List<Inquilino> inquilinos = findAll();
        for (Inquilino inquilino : inquilinos) {
            resultado.add(inquilino.toString());
        }

        return resultado;
    }
}
