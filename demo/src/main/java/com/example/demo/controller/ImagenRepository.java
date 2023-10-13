package com.example.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Imagen;

public interface ImagenRepository extends JpaRepository<Imagen, String> {

}
