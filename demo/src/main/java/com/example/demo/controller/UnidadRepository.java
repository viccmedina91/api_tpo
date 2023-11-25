package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Unidad;

public interface UnidadRepository extends JpaRepository<Unidad, Integer> {

}
