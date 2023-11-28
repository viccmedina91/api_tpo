package com.example.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
