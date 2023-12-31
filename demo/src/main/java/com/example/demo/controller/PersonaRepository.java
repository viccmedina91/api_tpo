package com.example.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {
    Persona findByDocumento(String documento);

}
