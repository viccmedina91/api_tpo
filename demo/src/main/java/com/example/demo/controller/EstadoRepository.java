package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
