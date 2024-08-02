package ar.edu.davinci.hito_dos.controller;

import ar.edu.davinci.hito_dos.model.Cancion;
import ar.edu.davinci.hito_dos.model.Genero;
import ar.edu.davinci.hito_dos.model.Puntaje;
import ar.edu.davinci.hito_dos.model.Usuario;
import ar.edu.davinci.hito_dos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{usuarioId}/canciones-recomendadas")
    public List<Cancion> getCancionesRecomendadas(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.findById(usuarioId);

        List<Cancion> cancionesFavoritas = new ArrayList<>();

        for (Puntaje puntaje : usuario.getPuntajes()) {
            if (puntaje.getPuntaje() >= 3.5 && puntaje.getCancion() != null) {
                cancionesFavoritas.add(puntaje.getCancion());
            }
        }

        Set<Genero> generosFavoritos = new HashSet<>();

        for (Cancion cancion : cancionesFavoritas) {
            generosFavoritos.add(cancion.getGenero());
        }

        List<Cancion> listaCanciones = usuarioService.findAllCanciones();
        List<Cancion> cancionesRecomendadas = new ArrayList<>();
        for (Cancion cancion : listaCanciones) {
            if (generosFavoritos.contains(cancion.getGenero())) {
                cancionesRecomendadas.add(cancion);
            }
        }

        return cancionesRecomendadas;
    }
}
