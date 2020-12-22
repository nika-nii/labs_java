package ru.bstu.iitus.vt41.kid.cw.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bstu.iitus.vt41.kid.cw.models.Track;
import ru.bstu.iitus.vt41.kid.cw.repositories.TrackRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class TrackController {
    private final TrackRepository repository;

    TrackController(TrackRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/tracks")
    List<Track> all() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/tracks")
    Track newTrack(@RequestBody Track newTrack) {
        return repository.save(newTrack);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/tracks/{id}")
    Optional<Track> one(@PathVariable Long id) {
        return repository.findById(id);
    }
}
