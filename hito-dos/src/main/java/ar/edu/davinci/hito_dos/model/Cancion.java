package ar.edu.davinci.hito_dos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity @Table(name = "canciones")
public class Cancion {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String letra;


    private String genero;


    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Disco disco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Artista artista;

    public Cancion() {}

    public Cancion(String nombre, String letra, String genero) {
        this.nombre = nombre;
        this.letra = letra;
        this.genero = genero;
    }

    // Getters y Setters
    public void setGenero(String genero) {this.genero = genero;}


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

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }


    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }
}
