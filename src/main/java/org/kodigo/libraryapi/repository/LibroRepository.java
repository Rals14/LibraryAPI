package org.kodigo.libraryapi.repository;

import org.kodigo.libraryapi.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTitulo(String titulo);

    List<Libro> findByDisponible(Boolean disponible);

}
