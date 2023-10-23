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

    public default List<String> listarPorUnidad(Integer codigo) {
        List<Reclamo> reclamos = findAll();
        List<String> resultado = new ArrayList<String>();
        for (Reclamo reclamo : reclamos) {
            if (reclamo.getUnidad().getIdentificador() == codigo) {
                resultado.add(reclamo.toString());
            }
        }
        return resultado;
    }

    public default List<String> listarPorPersona(String codigo) {
        List<Reclamo> reclamos = findAll();
        List<String> resultado = new ArrayList<String>();
        for (Reclamo reclamo : reclamos) {
            if (reclamo.getPersona().getDocumento().equals(codigo)) {
                resultado.add(reclamo.toString());
            }
        }
        return resultado;
    }
}