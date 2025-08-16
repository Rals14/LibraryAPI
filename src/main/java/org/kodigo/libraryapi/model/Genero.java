package org.kodigo.libraryapi.model;

import jakarta.persistence.*;

@Entity
@Table (name = "genero")

public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;

    public Genero() {
    }

    public Genero(String nombre, Long id) {
        this.nombre = nombre;
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
