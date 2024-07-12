package ar.edu.davinci.hito_dos.service;

import ar.edu.davinci.hito_dos.model.Artista;
import ar.edu.davinci.hito_dos.model.Cancion;
import ar.edu.davinci.hito_dos.model.Genero;
import ar.edu.davinci.hito_dos.repository.ArtistaRepository;
import ar.edu.davinci.hito_dos.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CancionService {
    @Autowired
    public CancionRepository cancionRepository;
    @Autowired
    public ArtistaRepository artistaRepository;

    public Cancion crear(String nombre, String letra, Genero genero, Long artistaId) {
        Cancion nuevacancion = new Cancion(nombre, letra, genero);
        nuevacancion =cancionRepository.save(nuevacancion);
        Artista artista = artistaRepository.findById(artistaId).get();
        artista.addCancion(nuevacancion);
        artistaRepository.save(artista);
        return cancionRepository.save(nuevacancion);
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

    public Cancion actualizarCancion(Long id, String nombre, String letra, Genero genero) {
        Cancion nuevacancion = new Cancion(nombre, letra, genero);
        nuevacancion.setId(id);
        cancionRepository.save(nuevacancion);
        return nuevacancion;
    }
}