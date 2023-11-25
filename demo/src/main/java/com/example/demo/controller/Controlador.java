package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

// Entidades
import com.example.demo.entity.Edificio;
import com.example.demo.entity.Persona;
import com.example.demo.entity.Reclamo;
import com.example.demo.entity.Unidad;
import com.example.demo.entity.UnidadPersona;
import com.example.demo.entity.Reclamo;
// Views
import com.example.demo.views.EdificioConUnidadesView;
import com.example.demo.views.EdificioView;
import com.example.demo.views.PersonaView;
import com.example.demo.views.ReclamoView;
import com.example.demo.views.UnidadView;

// Excepciones
import com.example.demo.exceptions.EdificioException;
import com.example.demo.exceptions.ReclamoException;

@Controller
public class Controlador {
    private static Controlador instancia;
    private final EdificioRepository edificioRepository;
    private final PersonaRepository personaRepository;
    private final UnidadRepository unidadRepository;
    private final ReclamoRepository reclamoRepository;

    private Controlador(EdificioRepository edificioRepository, PersonaRepository personaRepository,
            UnidadRepository unidadRepository, ReclamoRepository reclamoRepository) {
        this.edificioRepository = edificioRepository;
        this.personaRepository = personaRepository;
        this.unidadRepository = unidadRepository;
        this.reclamoRepository = reclamoRepository;
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
        if (unidad.getHabitado()) {
            unidadExistente.setHabitado("S");
        } else {
            unidadExistente.setHabitado("N");
        }

        unidadExistente.setNumero(unidad.getNumero());
        this.unidadRepository.save(unidadExistente);
        return unidadExistente.toView();
    }

    public String transferirUnidad(UnidadPersona unidadPersona) {
        Unidad unidad = this.buscarUnidad(Integer.parseInt(unidadPersona.getCodigoUnidad()));
        if (unidad == null) {
            return "La unidad no existe";
        }

        Persona persona = this.buscarPersona(unidadPersona.getDocumento());
        if (persona == null) {
            return "La persona no existe";
        }
        unidad.transferir(persona);
        this.unidadRepository.save(unidad);
        return "200 OK";
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

    public PersonaView agregarDuenioUnidad(UnidadPersona unidadPersona) {
        Unidad unidad = buscarUnidad(Integer.parseInt(unidadPersona.getCodigoUnidad()));
        Persona persona = buscarPersona(unidadPersona.getDocumento());
        if (unidad == null) {
            return null;
        }
        if (persona == null) {
            return null;
        }
        unidad.agregarDuenio(persona);
        this.unidadRepository.save(unidad);
        return persona.toView();
    }

    public Boolean agregarInquilinoUnidad(UnidadPersona unidadPersona) {
        Unidad unidad = this.buscarUnidad(Integer.parseInt(unidadPersona.getCodigoUnidad()));
        Persona persona = buscarPersona(unidadPersona.getDocumento());
        if (unidad.getInquilinos().isEmpty()) {
            unidad.alquilar(persona);
        } else {
            if (!unidad.getInquilinos().contains(persona)) {
                unidad.agregarInquilino(persona);

            } else {
                return false;
            }
        }
        this.actualizarUnidad(unidad, unidad.getIdentificador());
        return true;
    }

    public Boolean liberarUnidad(int codigo) {
        Unidad unidad = buscarUnidad(codigo);
        if (unidad == null) {
            return null;
        }
        unidad.liberar();
        this.actualizarUnidad(unidad, unidad.getIdentificador());
        return true;
    }

    public Boolean habitarUnidad(int codigo) {
        Unidad unidad = buscarUnidad(codigo);
        if (unidad == null) {
            return null;
        }
        unidad.habitar();
        this.actualizarUnidad(unidad, unidad.getIdentificador());
        return true;
    }

    public List<ReclamoView> reclamosPorEdificio(int codigo) {
        Edificio edificio = this.buscarEdificio(codigo);
        if (edificio == null) {
            return null;
        }
        return this.reclamoRepository.findAll().stream().filter(r -> r.getEdificio().getCodigo() == codigo)
                .map(Reclamo::toView).toList();
    }

    public List<ReclamoView> reclamosPorUnidad(int codigo) {
        Unidad unidad = this.buscarUnidad(codigo);
        if (unidad == null) {
            return null;
        }
        return this.reclamoRepository.findAll().stream().filter(r -> r.getUnidad().getIdentificador() == codigo)
                .map(Reclamo::toView).toList();
    }

    public ReclamoView reclamosPorNumero(int numero) throws ReclamoException {
        Optional<Reclamo> reclamo = this.reclamoRepository.findById(numero);
        if (reclamo.isPresent()) {
            return reclamo.get().toView();
        }

        return null;
    }

    public List<ReclamoView> reclamosPorPersona(String documento) {
        Persona persona = this.buscarPersona(documento);
        if (persona == null) {
            return null;
        }
        return this.reclamoRepository.findAll().stream().filter(r -> r.getUsuario().getDocumento().equals(documento))
                .map(Reclamo::toView).toList();
    }

    public PersonaView agregarPersona(Persona persona) {
        Persona existe = this.buscarPersona(persona.getDocumento());
        if (existe != null) {
            return null;
        }

        return this.personaRepository.save(persona).toView();
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

    private Persona buscarPersona(String documento) {
        Optional<Persona> persona = this.personaRepository.findById(documento);
        if (persona.isPresent()) {
            return persona.get();
        }
        return null;
    }

}
