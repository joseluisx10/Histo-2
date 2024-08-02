package ar.edu.davinci.hito_dos.controller;
import ar.edu.davinci.hito_dos.model.Puntaje;
import ar.edu.davinci.hito_dos.service.PuntajeService;
import ar.edu.davinci.hito_dos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/puntuar")
public class PuntajeController {
    @Autowired
    private PuntajeService puntajeService;

    @PostMapping("/disco/{discoId}/usuario/{usuarioId}")
    public Puntaje puntuarDisco(@PathVariable Long discoId,  @PathVariable Long usuarioId, @RequestBody double puntaje) {
        return puntajeService.puntuarDisco(discoId, usuarioId, puntaje);
    }

    @PostMapping("/cancion/{cancionId}/usuario/{usuarioId}")
    public Puntaje puntuarCancion(@PathVariable Long cancionId, @PathVariable Long usuarioId, @RequestBody double puntaje) {
        return puntajeService.puntuarCancion(cancionId, usuarioId, puntaje);
    }
}
