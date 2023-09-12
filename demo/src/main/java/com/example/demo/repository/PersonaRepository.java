package com.example.demo.repository;

import com.example.demo.entity.Persona;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, String> {
    Optional<Persona> findByDocumento(String documento);

}
