package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
    List<Edificio> findAll();

    Optional<Edificio> findById(Integer id);
}