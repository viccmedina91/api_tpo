package com.example.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, String> {
    Edificio findByCodigo(Integer codigo);
}