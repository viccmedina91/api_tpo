package com.example.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Reclamo;

public interface ReclamoRepository extends JpaRepository<Reclamo, Integer> {

}