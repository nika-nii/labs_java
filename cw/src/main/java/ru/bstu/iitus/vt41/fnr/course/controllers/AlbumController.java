package ru.bstu.iitus.vt41.fnr.course.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bstu.iitus.vt41.fnr.course.repositories.AlbumRepository;
import ru.bstu.iitus.vt41.fnr.course.models.Album;

import java.util.List;
import java.util.Optional;

@RestController
public class AlbumController {
    private final AlbumRepository repository;

    AlbumController(AlbumRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/albums")
    List<Album> all(@RequestParam(required = false) String title) {
        if (title == null) {
            return repository.findAll();
        }
        return  repository.findAlbumByTitle(title);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/albums")
    Album newAlbum(@RequestBody Album newAlbum){
        return repository.save(newAlbum);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/albums/{id}")
    Optional<Album> one(@PathVariable Long id){
        return repository.findById(id);
    }
}
