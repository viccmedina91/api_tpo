package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Reclamo;
import com.example.demo.requests.ModificarEstadoRequest;

public interface ReclamoRepository extends JpaRepository<Reclamo, Integer> {

    public default String actualizarEstado(ModificarEstadoRequest rReclamo) {
        Reclamo reclamo = buscarPorID(rReclamo.getReclamoid());
        String estadoActual = reclamo.getEstado().getDescripcion();
        String estadoNuevo = rReclamo.getEstado();
        if ((estadoActual.equals("Pendiente")) && (estadoNuevo.equals("En Proceso"))) {
            return "ok";

        } else {
            if ((estadoActual.equals("En Proceso")) && (estadoNuevo.equals("Cumplido"))) {
                return "ok";
            }
        }
        return "Estado inválido";
    }

    public default Reclamo buscarPorID(Integer nro) {
        List<Reclamo> reclamos = findAll();
        for (Reclamo reclamo : reclamos) {
            if (reclamo.getIdReclamo() == nro) {
                return reclamo;
            }
        }
        return null;
    }

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