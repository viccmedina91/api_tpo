package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Reclamo;

public interface ReclamoRepository extends JpaRepository<Reclamo, String> {
    public default List<Reclamo> findReclamoPorEdificio(Integer identificador) {
        List<Reclamo> reclamos = findAll();
        List<Reclamo> porEdificio = new ArrayList<Reclamo>();
        for (Reclamo reclamo : reclamos) {
            if (reclamo.getEdificio().getCodigo() == identificador) {
                porEdificio.add(reclamo);
            }
        }
        return porEdificio;
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