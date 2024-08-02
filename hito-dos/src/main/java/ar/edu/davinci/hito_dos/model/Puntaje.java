package ar.edu.davinci.hito_dos.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@Table(name = "puntajes")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Puntaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "disco_id", nullable = true)
    private Disco disco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cancion_id", nullable = true)
    private Cancion cancion;
    @Column(name = "puntaje", nullable = false)
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

    public Cancion getCancion() {
        return this.cancion;
    }

    public void addDisco(Disco disco) {
        this.disco = disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }
}