package ru.bstu.iitus.vt41.fnr.course.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bstu.iitus.vt41.fnr.course.repositories.GenreRepository;
import ru.bstu.iitus.vt41.fnr.course.models.Genre;

import java.util.List;
import java.util.Optional;

@RestController
public class GenreController {
    private final GenreRepository repository;

    GenreController(GenreRepository repository){
        this.repository = repository;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/genres")
    List<Genre> all() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/genres")
    Genre newGenre(@RequestBody Genre newGenre){
        return repository.save(newGenre);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/genres/{id}")
    Optional<Genre> one(@PathVariable Long id){
        return repository.findById(id);
    }
}
