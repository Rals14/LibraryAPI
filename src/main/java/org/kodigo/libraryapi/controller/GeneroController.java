package org.kodigo.libraryapi.controller;

import org.kodigo.libraryapi.model.Editorial;
import org.kodigo.libraryapi.model.Genero;
import org.kodigo.libraryapi.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")

public class GeneroController {
    @Autowired

    private GeneroRepository repository;

    @GetMapping("/generos")
    public List<Genero> findAll() {
        return repository.findAll();
    }

    @GetMapping("/generos/{id}")
    public Genero findById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/generos/nombre/{nombre}")
    public List<Genero> findByNombre(@PathVariable String nombre) {
        return repository.findByNombre(nombre);
    }

    @PostMapping("/generos")
    public ResponseEntity<?> add(@RequestBody Genero genero)  {
        List<Genero> existing = repository.findByNombre(genero.getNombre());
        if (!existing.isEmpty()) {
            return ResponseEntity.badRequest().body("A genre with this name already exists.");
        }
        Genero saved = repository.save(genero);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/generos/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Genre deleted successfully");
    }

}
