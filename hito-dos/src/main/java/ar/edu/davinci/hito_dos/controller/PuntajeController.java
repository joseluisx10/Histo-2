package ar.edu.davinci.hito_dos.controller;

import ar.edu.davinci.hito_dos.model.Cancion;
import ar.edu.davinci.hito_dos.model.Disco;
import ar.edu.davinci.hito_dos.model.Puntaje;
import ar.edu.davinci.hito_dos.model.Usuario;
import ar.edu.davinci.hito_dos.service.CancionService;
import ar.edu.davinci.hito_dos.service.DiscoService;
import ar.edu.davinci.hito_dos.service.PuntajeService;
import ar.edu.davinci.hito_dos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/puntajes")
public class PuntajeController {
    @Autowired
    private PuntajeService puntajeService;

    @GetMapping("/disco/{discoId}/usuario/{usuarioId}")
    public Puntaje puntuarDisco(@PathVariable Long discoId,  @PathVariable Long usuarioId, @RequestBody double puntaje) {
        return puntajeService.puntuarDisco(discoId, usuarioId, puntaje);
    }

    @GetMapping("/cancion/{cancionId}/usuario/{usuarioId}")
    public Puntaje puntuarCancion(@PathVariable Long cancionId, @PathVariable Long usuarioId, @RequestBody double puntaje) {
        return puntajeService.puntuarCancion(cancionId, usuarioId, puntaje);
    }
}
