package org.kodigo.libraryapi.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private Long anio_publicacion;
    private Boolean disponible;
    private Long autor_id;
    private Long editorial_id;
    private Long genero_id;

    public Libro() {
    }

    public Libro(Long id, String titulo, Long anio_publicacion, Long autor_id, Boolean disponible, Long editorial_id, Long genero_id) {
        this.id = id;
        this.titulo = titulo;
        this.anio_publicacion = anio_publicacion;
        this.autor_id = autor_id;
        this.disponible = disponible;
        this.editorial_id = editorial_id;
        this.genero_id = genero_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(Long anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Long getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(Long autor_id) {
        this.autor_id = autor_id;
    }

    public Long getEditorial_id() {
        return editorial_id;
    }

    public void setEditorial_id(Long editorial_id) {
        this.editorial_id = editorial_id;
    }

    public Long getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(Long genero_id) {
        this.genero_id = genero_id;
    }
}
