package org.kodigo.libraryapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "editorial")

public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String pais;

    public Editorial() {
    }

    public Editorial(String nombre, Long id, String direccion, String telefono, String pais) {
        this.nombre = nombre;
        Id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pais = pais;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
