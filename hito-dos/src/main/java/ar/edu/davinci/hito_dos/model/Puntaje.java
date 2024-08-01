package ar.edu.davinci.hito_dos.model;


import jakarta.persistence.*;

@Entity
@Table(name = "puntajes")
public class Puntaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "disco_id", nullable = true)
    private Disco disco;

    @ManyToOne
    @JoinColumn(name = "cancion_id", nullable = true)
    private Cancion cancion;

    private double puntaje;

    public Puntaje() {}

    public Puntaje(Usuario usuario, Disco disco, double puntaje) {
        this.usuario = usuario;
        this.disco = disco;
        this.puntaje = puntaje;
    }

    public Puntaje(Usuario usuario, Cancion cancion, double puntaje) {
        this.usuario = usuario;
        this.cancion = cancion;
        this.puntaje = puntaje;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getPuntaje() {
        return this.puntaje;
    }

}