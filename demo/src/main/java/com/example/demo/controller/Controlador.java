package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;

// Entidades
import com.example.demo.entity.Edificio;
import com.example.demo.entity.Estado;
import com.example.demo.entity.Imagen;
import com.example.demo.entity.Inquilino;
import com.example.demo.entity.Persona;
import com.example.demo.entity.Reclamo;
import com.example.demo.entity.Unidad;
import com.example.demo.entity.UnidadPersona;
import com.example.demo.entity.Reclamo;
// Views
import com.example.demo.views.EdificioConUnidadesView;
import com.example.demo.views.EdificioView;
import com.example.demo.views.Login;
import com.example.demo.views.NuevoEstado;
import com.example.demo.views.NuevoReclamo;
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
    private final EstadoRepository estadoRepository;

    private Controlador(EdificioRepository edificioRepository, PersonaRepository personaRepository,
            UnidadRepository unidadRepository, ReclamoRepository reclamoRepository,
            EstadoRepository estadoRepository) {
        this.edificioRepository = edificioRepository;
        this.personaRepository = personaRepository;
        this.unidadRepository = unidadRepository;
        this.reclamoRepository = reclamoRepository;
        this.estadoRepository = estadoRepository;
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
            return null;
        }
        if (edificio.getUnidades().size() > 0) {
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
            return "Error, La unidad no existe";
        }
        Persona persona = this.buscarPersona(unidadPersona.getDocumento());
        if (persona == null) {
            System.out.println("LA PERSONA NO EXISTE");
            return "Error, La persona no existe";
        }
        unidad.transferir(persona);
        this.unidadRepository.save(unidad);
        return "Unidad transferida con éxito";
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

    public String agregarDuenioUnidad(UnidadPersona unidadPersona) {
        Unidad unidad = this.buscarUnidad(Integer.parseInt(unidadPersona.getCodigoUnidad()));
        if (unidad == null) {
            return "Error, el Nro de unidad ingresado no existe: " + unidadPersona.getCodigoUnidad();
        }

        Persona persona = buscarPersona(unidadPersona.getDocumento());
        if (persona == null) {
            return "Error, la persona ingresada no existe: " + unidadPersona.getDocumento();
        }
        unidad.agregarDuenio(persona);
        this.unidadRepository.save(unidad);
        return "OK, la persona se ha agregado con éxito";
    }

    public String eliminarPersona(String documento) {
        Persona persona = this.buscarPersona(documento);
        if (persona == null) {
            return "La persona no se encuentra registada";
        }

        // si la persona es dueño o inquilino, no se puede eliminar
        if (this.esDuenioHabitante(persona)) {
            return "La persona es Dueño o Inquilino activo, no se puede Eliminar";
        }

        // si la persona tiene reclamos iniciados, no se puede eliminar
        List<ReclamoView> reclamos = this.reclamosPorPersona(documento);
        if (reclamos.stream().filter(elemento -> elemento.getEstado().getID() < 4)
                .collect(Collectors.toList()).size() > 0) {
            return "La persona tiene reclamos activos";
        }
        this.personaRepository.delete(persona);
        return "Persona eliminada con exito: DNI: " + documento;

    }

    public String agregarInquilinoUnidad(UnidadPersona unidadPersona) {
        Unidad unidad = this.buscarUnidad(Integer.parseInt(unidadPersona.getCodigoUnidad()));
        if (unidad == null) {
            return "Error, el Nro de unidad no existe: " + unidadPersona.getCodigoUnidad();
        }
        Persona persona = buscarPersona(unidadPersona.getDocumento());
        if (persona == null) {
            return "Error, la persona no existe: " + unidadPersona.getDocumento();
        }
        if (unidad.getInquilinos().isEmpty()) {
            unidad.alquilar(persona);
        } else {
            if (!unidad.getInquilinos().contains(persona)) {
                unidad.agregarInquilino(persona);

            } else {
                return "Error, la persona ya es Inquilina";
            }
        }
        this.actualizarUnidad(unidad, unidad.getIdentificador());
        return "OK, la operación fue exitosa, inquilino: " + unidadPersona.getDocumento() + " agreado a unidad: "
                + unidadPersona.getCodigoUnidad();
    }

    public Boolean liberarUnidad(int codigo) {
        Unidad unidad = this.buscarUnidad(codigo);
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

    public String agregarReclamo(NuevoReclamo reclamo) throws ReclamoException {
        Edificio edificio = this.buscarEdificio(reclamo.getCodigo());
        if (edificio == null) {
            return "El edificio no existe" + reclamo.getCodigo();
        }

        Unidad unidad = this.buscarUnidad(reclamo.getIdentificador());
        if (unidad == null) {
            return "La unidad no existe: " + reclamo.getIdentificador();
        }

        Persona persona = this.buscarPersona(reclamo.getDocumento());
        if (persona == null) {
            return "La persona no existe: " + reclamo.getDocumento();
        }

        // validamos que la unidad pertenezca al edificio
        if (edificio.getUnidades().contains(unidad) == false) {
            return "Error, la unidad no pertenece al edificio";
        }

        // si la unidad esta alquilada, solamente el inquilino puede generar el reclamo
        if ((unidad.estaHabitado()) && (unidad.getDuenios().contains(persona))) {
            // si la unidad esta alquilada y la persona que inicia el reclamo es dueño
            // el reclamo no puede crearse.
            return "La unidad está habitada y la persona es dueño";
        }

        // si la unidad no esta habitada y la persona es dueño, puede hacer el reclamo
        if ((unidad.estaHabitado() == false) && (unidad.getDuenios().contains(persona))) {
            return "Guardado con Exito, nro de reclamo: "
                    + this.almacenarReclamo(reclamo, persona, edificio, unidad).getNumero();
        }

        // si la unidad esta habitada y la persona es inquilino
        if ((unidad.estaHabitado()) && (unidad.getInquilinos().contains(persona))) {
            return "Guardado con Exito, nro de reclamo: "
                    + this.almacenarReclamo(reclamo, persona, edificio, unidad).getNumero();
        }

        return "Error";
    }

    public String agregarImagenAReclamo(int numero, Imagen imagenes) throws ReclamoException {
        Reclamo reclamo = this.buscarReclamo(numero);
        if (reclamo == null) {
            return "Error, Nro de reclamo desconocido: " + numero;
        }
        reclamo.agregarImagen(imagenes.getPath(), imagenes.getTipo());
        this.reclamoRepository.save(reclamo);
        return "Guardado con Exito";
    }

    public String cambiarEstado(NuevoEstado nuevoEstado) {
        // validamos el nro de reclamo
        Reclamo reclamo = this.buscarReclamo(nuevoEstado.getNumero());
        if (reclamo == null) {
            return "Error, Nro de reclamo desconocido: " + nuevoEstado.getNumero();
        }
        // validamos que el estado nuevo sea un valor valido
        Estado estado = this.buscarEstado(nuevoEstado.getEstado());
        if (estado == null) {
            return "Estado nuevo inválido";
        }
        // estado nuevo es igual a estado actual
        if (reclamo.getEstado().getID() == nuevoEstado.getEstado()) {
            return "El estado actual y el estado nuevo son iguales";
        }
        // para estados 1,2,3 y quieran pasar a 4,5,6
        Integer estadoActual = reclamo.getEstado().getID();
        if ((estadoActual < nuevoEstado.getEstado()) && (estadoActual < 4)) {
            reclamo.setEstado(estado);
            this.reclamoRepository.save(reclamo);
            return "Guardado con Exito";
        }
        // para los estados 4, 5 y 6 y quiere pasar a un estado anterior
        if ((estadoActual >= 4) && (nuevoEstado.getEstado() < estadoActual)) {
            return "El reclamo se encuentra en un estado final. No se puede cambiar.";
        }

        return "Error";
    }

    public String validarLogin(Login login) {
        List<PersonaView> personas = this.getPersonas().stream()
                .filter(elemento -> elemento.getMail() != null)
                .filter(elemento -> elemento.getMail().equals(login.getMail()))
                .collect(Collectors.toList());

        if (personas.size() > 1) {
            return "error";
        }
        System.out.println("............. " + personas.get(0).getDocumento());
        if (personas.get(0).getContrasenia().equals(login.getContrasenia())) {
            if (login.getMail().contains("admin")) {
                return "admin";
            } else {
                return "otro";
            }
        }

        return "error";

    }

    public String actualizarPersona(PersonaView persona, String documento) {
        // verificar si la persona existe
        Persona personaExiste = this.buscarPersona(documento);
        if (personaExiste == null) {
            return "La persona no existe: " + documento;
        }
        personaExiste.setContrasenia(persona.getContrasenia());
        personaExiste.setMail(persona.getMail());
        personaExiste.setNombre(persona.getNombre());
        this.personaRepository.save(personaExiste);
        return "Actualización con éxito";
    }

    public PersonaView agregarPersona(Persona persona) {
        Persona existe = this.buscarPersona(persona.getDocumento());
        if (existe != null) {
            return null;
        }

        return this.personaRepository.save(persona).toView();
    }

    private Boolean esDuenioHabitante(Persona persona) {
        List<EdificioView> edificios = this.getEdificios();
        for (EdificioView edificio : edificios) {
            Edificio edi = this.buscarEdificio(edificio.getCodigo());
            if ((edi.habitantes().contains(persona)) || (edi.duenios().contains(persona))) {
                return true;
            }
        }
        return false;
    }

    private Estado buscarEstado(Integer idEstado) {
        Optional<Estado> estado = this.estadoRepository.findById(idEstado);
        if (estado.isPresent()) {
            return estado.get();
        }
        return null;

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

    private Reclamo buscarReclamo(Integer numero) {
        Optional<Reclamo> reclamo = this.reclamoRepository.findById(numero);
        if (reclamo.isPresent()) {
            return reclamo.get();
        }
        return null;
    }

    private Reclamo almacenarReclamo(NuevoReclamo reclamo, Persona persona, Edificio edificio, Unidad unidad) {
        Estado estado = this.estadoRepository.findById(1).get();
        Reclamo nuevoReclamo = new Reclamo(persona, edificio, reclamo.getUbicacion(),
                reclamo.getDescripcion(), unidad, estado);
        this.reclamoRepository.save(nuevoReclamo);
        return nuevoReclamo;
    }

}
