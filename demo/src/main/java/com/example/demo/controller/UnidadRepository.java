package com.example.demo.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

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

    List<Unidad> findByEdificioCodigo(Integer codigoEdificio);
}
