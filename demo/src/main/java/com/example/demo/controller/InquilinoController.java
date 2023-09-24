package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class InquilinoController {
    private final InquilinoRepository inquiniloRepository;

    @Autowired
    public InquilinoController(InquilinoRepository inquiniloRepository) {
        this.inquiniloRepository = inquiniloRepository;
    }
}
