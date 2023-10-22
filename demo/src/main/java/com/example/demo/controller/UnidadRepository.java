package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Duenio;
import com.example.demo.entity.Unidad;

public interface UnidadRepository extends JpaRepository<Unidad, Integer> {
    public default Unidad findUnidadByIdentificador(Integer identificador) {
        List<Unidad> unidades = findAll();
        Unidad unidadRecovery = null;
        for (Unidad unidad : unidades) {
            if (unidad.getIdentificador().equals(identificador)) {
                unidadRecovery = unidad;
                return unidadRecovery;
            }
        }
        return unidadRecovery;
    }

    public List<Unidad> findByEdificioCodigo(Integer codigoEdificio);

    public default List<Duenio> findDueniosPorEdificio(Integer codigoEdificio) {
        List<Unidad> unidades = findByEdificioCodigo(codigoEdificio);
        List<Duenio> duenios = new ArrayList<Duenio>();

        for (Unidad unidad : unidades) {
            duenios.add(unidad.getDuenio());
        }

        return duenios;
    }

    public default List<String> listarUnidades(List<Unidad> unidades) {
        List<String> resultado = new ArrayList<String>();
        for (Unidad unidad : unidades) {
            resultado.add(unidad.toString());
        }
        return resultado;
    }

}
