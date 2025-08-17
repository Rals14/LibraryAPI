package org.kodigo.libraryapi.controller;

import org.kodigo.libraryapi.model.Editorial;
import org.kodigo.libraryapi.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")

public class EditorialController {

    @Autowired
    private EditorialRepository repository;

    @GetMapping("/editoriales")
    public List<Editorial> findAll() {
        return repository.findAll();
    }

    @GetMapping("/editoriales/{id}")
    public Editorial findById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/editoriales/nombre/{nombre}")
    public List<Editorial> findByNombre(@PathVariable String nombre) {
        return repository.findByNombre(nombre);
    }

    @GetMapping("/editoriales/pais/{pais}")
    public List<Editorial> findByPais(@PathVariable String pais) {
        return repository.findByPais(pais);
    }

    @PostMapping("/editoriales")
    public ResponseEntity<?> add(@RequestBody Editorial editorial)  {
        List<Editorial> existing = repository.findByNombre(editorial.getNombre());
        if (!existing.isEmpty()) {
            return ResponseEntity.badRequest().body("An editorial with this name already exists.");
        }
        Editorial saved = repository.save(editorial);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/editoriales/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Publisher deleted successfully");
    }
}
