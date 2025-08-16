package org.kodigo.libraryapi.repository;

import org.kodigo.libraryapi.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long> {
    List<Editorial> findByNombre(String nombre);

    List<Editorial> findByPais(String pais);
}
