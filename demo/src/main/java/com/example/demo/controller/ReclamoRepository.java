package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Reclamo;

public interface ReclamoRepository extends JpaRepository<Reclamo, String> {
    public default List<String> listarTodos() {
        List<Reclamo> reclamos = findAll();
        List<String> resultado = new ArrayList<String>();
        for (Reclamo reclamo : reclamos) {
            resultado.add(reclamo.toString());
        }
        return resultado;
    }

    public default List<String> listarPorEdificio(Integer codigo) {
        List<Reclamo> reclamos = findAll();
        List<String> resultado = new ArrayList<String>();
        for (Reclamo reclamo : reclamos) {
            if (reclamo.getEdificio().getCodigo() == codigo) {
                resultado.add(reclamo.toString());
            }
        }
        return resultado;
    }

    public default List<Reclamo> findReclamoPorUnidad(Integer identificador) {
        List<Reclamo> reclamos = findAll();
        List<Reclamo> porUnidad = new ArrayList<Reclamo>();
        for (Reclamo reclamo : reclamos) {
            if (reclamo.getUnidad().getNumero() == identificador) {
                porUnidad.add(reclamo);
            }
        }
        return porUnidad;
    }

    public default List<Reclamo> findReclamoPorPersona(String documento) {
        List<Reclamo> reclamos = findAll();
        List<Reclamo> porPersona = new ArrayList<Reclamo>();
        for (Reclamo reclamo : reclamos) {
            if (reclamo.getPersona().getDocumento() == documento) {
                porPersona.add(reclamo);
            }
        }
        return porPersona;

    }
}