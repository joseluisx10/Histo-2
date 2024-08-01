package ar.edu.davinci.hito_dos.service;

import ar.edu.davinci.hito_dos.model.Cancion;
import ar.edu.davinci.hito_dos.model.Disco;
import ar.edu.davinci.hito_dos.model.Puntaje;
import ar.edu.davinci.hito_dos.model.Usuario;
import ar.edu.davinci.hito_dos.repository.CancionRepository;
import ar.edu.davinci.hito_dos.repository.DiscoRepository;
import ar.edu.davinci.hito_dos.repository.PuntajeRepository;
import ar.edu.davinci.hito_dos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuntajeService {
    @Autowired
    private PuntajeRepository puntajeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DiscoRepository discoRepository;

    @Autowired
    private CancionRepository cancionRepository;

    public Puntaje puntuarDisco(Long discoId, Long usuarioId, double puntajeValor) {
        if (puntajeValor < 0 || puntajeValor > 5) {
            throw new RuntimeException("El puntaje debe estar entre 0 y 5.");
        }
        Usuario usuario = usuarioRepository.findById(usuarioId).get();
        Disco disco = discoRepository.findById(discoId).get();
        Puntaje puntaje = new Puntaje(usuario, disco, puntajeValor);
        return puntajeRepository.save(puntaje);
    }

    public Puntaje puntuarCancion(Long cancionId, Long usuarioId, double puntajeValor) {
        if (puntajeValor < 0 || puntajeValor > 5) {
            throw new RuntimeException("El puntaje debe estar entre 0 y 5.");
        }
        Usuario usuario = usuarioRepository.findById(usuarioId).get();
        Cancion cancion = cancionRepository.findById(cancionId).get();
        Puntaje puntaje = new Puntaje(usuario, cancion, puntajeValor);
        return puntajeRepository.save(puntaje);
    }
}
