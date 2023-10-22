package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Duenio;

public interface DuenioRepository extends JpaRepository<Duenio, Integer> {

    public default List<String> listarSegunEdifico(Integer codigoedificio) {
        List<Duenio> duenios = findAll();
        List<String> resultado = new ArrayList<String>();
        for (Duenio duenio : duenios) {
            if (duenio.getUnidad().getEdificio().getCodigo() == codigoedificio) {
                resultado.add(duenio.toString());
            }
        }
        return resultado;
    }

    public default List<String> listarTodos(List<Duenio> duenios) {
        List<String> resultado = new ArrayList<String>();
        for (Duenio duenio : duenios) {
            resultado.add(duenio.toString());
        }
        return resultado;
    }

    public default Duenio findDuenioByDocumento(String string) {
        List<Duenio> duenios = findAll();
        Duenio duenioExistente = null;
        for (Duenio duenio : duenios) {
            if (duenio.getPersona().getDocumento().equals(string)) {
                System.out.println("Duenio encontrado: " + duenio.toString());
                duenioExistente = duenio;
            }
        }
        return duenioExistente;
    }
}
