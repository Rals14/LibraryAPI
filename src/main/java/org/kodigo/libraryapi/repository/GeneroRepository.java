package org.kodigo.libraryapi.repository;

import org.kodigo.libraryapi.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
    List<Genero> findByNombre(String nombre);
}
