package ar.edu.davinci.hito_dos.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ElementCollection(targetClass = Genero.class)
    @CollectionTable(name = "artista_generos", joinColumns = @JoinColumn(name = "artista_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "genero")
    private List<Genero> generos;

    private String paisOrigen;
    private Date fechaNacimiento;
    private Date fechaFallecimiento;

    @ElementCollection(targetClass = Instrumento.class)
    @CollectionTable(name = "artista_instrumentos", joinColumns = @JoinColumn(name = "artista_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "instrumento")
    private List<Instrumento> instrumentos;

    private String biografia;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Disco> discosGrabados;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Cancion> canciones;

    public Artista() {}

    public Artista(String nombre, String paisOrigen, Date fechaNacimiento, Date fechaFallecimiento, Instrumento instrumentos, String biografia) {
        this.nombre = nombre;
        this.generos = new ArrayList<>();
        this.paisOrigen = paisOrigen;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaFallecimiento = fechaFallecimiento;
        this.instrumentos = new ArrayList<>();
        this.biografia = biografia;
        this.discosGrabados = new ArrayList<>();
        this.canciones = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void addGenero(Genero genero) {
        this.generos.add(genero);
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    public void addInstrumento(Instrumento instrumento) {
        this.instrumentos.add(instrumento);
    }

    public Date getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Date fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public List<Disco> getDiscosGrabados() {
        return discosGrabados;
    }

    public void addDiscoGrabado(Disco discosGrabado) {
        this.discosGrabados.add(discosGrabado);
    }

    public void addCancion(Cancion cancion) {
        this.canciones.add(cancion);
        cancion.setArtista(this);
    }

    public void addCanciones(List<Cancion> canciones) {
        for (Cancion cancion : canciones) {
            cancion.setArtista(this);
            this.canciones.add(cancion);
        }
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }
}
