package org.kodigo.libraryapi.controller;

import org.kodigo.libraryapi.model.Libro;
import org.kodigo.libraryapi.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibroController {
    @Autowired
    private LibroRepository libroRepository;

    @GetMapping("/libros")
    private List<Libro> findAll(){
        return libroRepository.findAll();
    }

    @GetMapping("/libros/{id}")
    private Libro libroById(@PathVariable Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @GetMapping("/libros/titulo/{titulo}")
    private List<Libro> libroByTitulo(@PathVariable String titulo) {
        return libroRepository.findByTitulo(titulo);
    }

    @GetMapping("/libros/disponibles")
    private List<Libro> librosDisponibles() {
        return libroRepository.findByDisponible(true);
    }

    @PostMapping("/libros")
    public ResponseEntity<?> addLibro(@RequestBody Libro libro) {
        List<Libro> existing = libroRepository.findByTitulo(libro.getTitulo());
        if (!existing.isEmpty()) {
            return ResponseEntity.badRequest().body("A book with this title already exists.");
        }
        Libro saved = libroRepository.save(libro);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/libros/{id}")
    private ResponseEntity<String> deleteLibro(@PathVariable Long id) {
        libroRepository.deleteById(id);
        return ResponseEntity.ok("Book deleted successfully");
    }

}
