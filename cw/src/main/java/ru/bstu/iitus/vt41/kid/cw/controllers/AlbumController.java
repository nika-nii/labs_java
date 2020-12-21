package ru.bstu.iitus.vt41.kid.cw.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bstu.iitus.vt41.kid.cw.models.Album;
import ru.bstu.iitus.vt41.kid.cw.repositories.AlbumRepository;

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
    List<Album> all() {
        return repository.findAll();
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
