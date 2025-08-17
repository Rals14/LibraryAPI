package org.kodigo.libraryapi.controller;
import org.kodigo.libraryapi.model.Autor;
import org.kodigo.libraryapi.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @GetMapping("/autors")
    public List<Autor> findAll() {
        return repository.findAll();
    }

    @GetMapping("/autor/{id}")
    public Autor findById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/autor/nacionalidad/{nacionalidad}")
    public List<Autor> findByNacionalidad(@PathVariable String nacionalidad) {
        return repository.findByNacionalidad(nacionalidad);
    }

    @GetMapping("/autor/nombre/{nombre}/{apellido}")
    public List<Autor> findByNombreAndApellido(@PathVariable String nombre, @PathVariable String apellido) {
        return repository.findByNombreAndApellido(nombre, apellido);
    }

    @PostMapping("/autor")
    public ResponseEntity<?> add(@RequestBody Autor autor) {
        List<Autor> existing = repository.findByNombreAndApellido(autor.getNombre(), autor.getApellido());
        if (!existing.isEmpty()) {
            return ResponseEntity.badRequest().body("An author with this name and surname already exists.");
        }
        Autor saved = repository.save(autor);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/autor/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Author deleted successfully");
    }

}
