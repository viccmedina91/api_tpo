package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

// Entidades
import com.example.demo.entity.Edificio;
import com.example.demo.entity.Persona;
import com.example.demo.entity.Unidad;

// Views
import com.example.demo.views.EdificioConUnidadesView;
import com.example.demo.views.EdificioView;
import com.example.demo.views.PersonaView;
import com.example.demo.views.UnidadView;

// Excepciones
import com.example.demo.exceptions.EdificioException;

@Controller
public class Controlador {
    private static Controlador instancia;
    private final EdificioRepository edificioRepository;
    private final PersonaRepository personaRepository;

    private Controlador(EdificioRepository edificioRepository, PersonaRepository personaRepository) {
        this.edificioRepository = edificioRepository;
        this.personaRepository = personaRepository;
    }

    public List<EdificioView> getEdificios() {
        List<Edificio> edificios = this.edificioRepository.findAll();
        System.out.println(edificios.toString());
        List<EdificioView> edificiosView = new ArrayList<>();
        for (Edificio edificio : edificios) {
            edificiosView.add(edificio.toView());

        }
        return edificiosView;
    }

    public List<PersonaView> getPersonas() {
        List<Persona> personas = this.personaRepository.findAll();
        List<PersonaView> personasView = new ArrayList<>();
        for (Persona persona : personas) {
            personasView.add(persona.toView());
        }
        return personasView;
    }

    public List<EdificioConUnidadesView> getEdificiosConUnidades() {
        return this.edificioRepository.findAll().stream().map(Edificio::toViewConUnidades).toList();
    }

    public List<UnidadView> getUnidadesPorEdificio(Integer codigo) throws EdificioException {
        List<UnidadView> resultado = new ArrayList<UnidadView>();
        Edificio edificio = this.buscarEdificio(codigo);
        if (edificio == null) {
            return null;
        }
        List<Unidad> unidades = edificio.getUnidades();
        for (Unidad unidad : unidades)
            resultado.add(unidad.toView());
        return resultado;
    }

    public List<PersonaView> dueniosPorEdificio(int codigo) throws EdificioException {
        Edificio edificio = this.buscarEdificio(codigo);
        if (edificio == null) {
            return null;
        }
        return edificio.duenios().stream().map(Persona::toView).toList();
    }

    private Edificio buscarEdificio(Integer codigo) throws EdificioException {
        Optional<Edificio> edificio = this.edificioRepository.findById(codigo);
        if (edificio.isPresent()) {
            return edificio.get();

        }
        return null;
    }

}
