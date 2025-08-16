package org.kodigo.libraryapi.repository;

import org.kodigo.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByNacionalidad(String nacionalidad);
    List<Autor> findByNombreAndApellido(String nombre, String apellido);
}
