package com.example.demo.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {
    List<Persona> findAll();

}
