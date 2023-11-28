package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Duenio;

public interface DuenioRepository extends JpaRepository<Duenio, Integer> {

}
