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
    private final UnidadRepository unidadRepository;

    private Controlador(EdificioRepository edificioRepository, PersonaRepository personaRepository,
            UnidadRepository unidadRepository) {
        this.edificioRepository = edificioRepository;
        this.personaRepository = personaRepository;
        this.unidadRepository = unidadRepository;
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

    public EdificioView buscarEdificioPorCodigo(Integer codigo) {
        Edificio edificio = this.buscarEdificio(codigo);
        if (edificio == null) {
            return null;
        }
        return edificio.toView();
    }

    public Edificio guardarEdificio(Edificio edificio) {
        return this.edificioRepository.save(edificio);
    }

    public EdificioView actualizarEdificio(Edificio edificio, int codigo) {
        Edificio edificioExistente = this.buscarEdificio(codigo);
        if (edificioExistente == null) {
            return null;
        }

        edificioExistente.setNombre(edificio.getDireccion());
        edificioExistente.setDireccion(edificio.getNombre());
        this.edificioRepository.save(edificioExistente);
        return edificioExistente.toView();
    }

    public EdificioView eliminarEdificio(Integer codigo) {
        Edificio edificio = this.buscarEdificio(codigo);
        if (edificio == null) {
            System.out.println("edificio null");
            return null;
        }
        if (edificio.getUnidades().size() > 0) {
            System.out.println("no hay unidades pero estro aca");
            return null;
        }

        this.edificioRepository.deleteById(codigo);
        return edificio.toView();
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

    public UnidadView buscarUnidadPorCodigo(Integer codigo) {
        Unidad unidad = this.buscarUnidad(codigo);
        if (unidad == null) {
            return null;
        }
        return unidad.toView();
    }

    public UnidadView guardarUnidad(Unidad unidad, Integer codigo) {
        Edificio edificio = this.buscarEdificio(codigo);
        if (edificio == null) {
            return null;
        }
        unidad.setEdificio(edificio);

        return this.unidadRepository.save(unidad).toView();
    }

    public UnidadView actualizarUnidad(Unidad unidad, int codigo) {
        Unidad unidadExistente = this.buscarUnidad(codigo);
        if (unidadExistente == null) {
            return null;
        }
        unidadExistente.setPiso(unidad.getPiso());
        unidadExistente.setHabitado(unidad.getHabitado());
        unidadExistente.setNumero(unidad.getNumero());
        this.unidadRepository.save(unidadExistente);
        return unidadExistente.toView();
    }

    public List<PersonaView> dueniosPorUnidad(int codigo) throws EdificioException {
        Unidad unidad = buscarUnidad(codigo);
        if (unidad == null) {
            return null;
        }
        return unidad.getDuenios().stream().map(Persona::toView).toList();
    }

    public List<PersonaView> dueniosPorEdificio(int codigo) throws EdificioException {
        Edificio edificio = this.buscarEdificio(codigo);
        if (edificio == null) {
            return null;
        }
        return edificio.duenios().stream().map(Persona::toView).toList();
    }

    public List<PersonaView> habilitadosPorEdificio(int codigo) throws EdificioException {
        Edificio edificio = buscarEdificio(codigo);
        if (edificio == null) {
            return null;
        }
        return edificio.habilitados().stream().map(Persona::toView).toList();
    }

    public List<PersonaView> inquilinosPorUnidad(int codigo) throws EdificioException {
        Unidad unidad = this.buscarUnidad(codigo);
        if (unidad == null) {
            return null;
        }
        return unidad.getInquilinos().stream().map(Persona::toView).toList();
    }

    public List<PersonaView> habitantesPorEdificio(int codigo) throws EdificioException {
        Edificio edificio = this.buscarEdificio(codigo);
        if (edificio == null) {
            return null;
        }
        return edificio.habitantes().stream().map(Persona::toView).toList();
    }

    private Edificio buscarEdificio(Integer codigo) throws EdificioException {
        Optional<Edificio> edificio = this.edificioRepository.findById(codigo);
        if (edificio.isPresent()) {
            return edificio.get();

        }
        return null;
    }

    private Unidad buscarUnidad(Integer codigo) throws EdificioException {
        Optional<Unidad> unidad = this.unidadRepository.findById(codigo);
        if (unidad.isPresent()) {
            return unidad.get();

        }
        return null;
    }

}
