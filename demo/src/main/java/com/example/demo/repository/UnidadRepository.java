package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Unidad;

public interface UnidadRepository extends JpaRepository<Unidad, Integer> {
    Optional<Unidad> findByIdentificador(Integer identificador);

}
