package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Reclamo;

public interface ReclamoRepository extends JpaRepository<Reclamo, Integer> {
    Optional<Reclamo> findByIdReclamo(Integer idReclamo);

}
