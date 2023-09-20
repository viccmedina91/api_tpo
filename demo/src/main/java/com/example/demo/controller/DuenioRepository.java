package com.example.demo.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Duenio;

public interface DuenioRepository extends JpaRepository<Duenio, Integer> {
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
