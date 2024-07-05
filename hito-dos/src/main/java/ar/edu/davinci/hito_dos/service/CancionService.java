package ar.edu.davinci.hito_dos.service;

import ar.edu.davinci.hito_dos.model.Cancion;
import ar.edu.davinci.hito_dos.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CancionService {
    @Autowired
    public CancionRepository cancionRepository;

    public Cancion crear(String nombre, String letra, String genero) {
        Cancion nuevacancion = new Cancion(nombre, letra, genero);
        cancionRepository.save(nuevacancion);
        return nuevacancion;
    }

    public Optional<Cancion> getCancionPorNombre(String nombre) {
        return cancionRepository.findByNombre(nombre);
    }

    public Optional<Cancion> getCancionPorId(long id) {
        return cancionRepository.findById(id);
    }

    public Optional<Cancion> getCancionPorLetra(String letra) {
        return cancionRepository.findByLetra(letra);
    }

    public Cancion actualizarCancion(Long id, String nombre, String letra, String genero) {
        Cancion nuevacancion = new Cancion(nombre, letra, genero);
        nuevacancion.setId(id);
        cancionRepository.save(nuevacancion);
        return nuevacancion;
    }
}