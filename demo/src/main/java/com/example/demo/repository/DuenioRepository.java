package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Duenio;

public interface DuenioRepository extends JpaRepository<Duenio, Integer> {
    Optional<Duenio> findById(Integer id);

}
