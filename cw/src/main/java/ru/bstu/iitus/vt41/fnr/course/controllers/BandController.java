package ru.bstu.iitus.vt41.fnr.course.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bstu.iitus.vt41.fnr.course.repositories.BandRepository;
import ru.bstu.iitus.vt41.fnr.course.models.Band;

import java.util.List;
import java.util.Optional;

@RestController
public class BandController {

    private final BandRepository repository;

    BandController(BandRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/bands")
    List<Band> all() {
        return (List<Band>) repository.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/bands")
    Band newBand(@RequestBody Band newBand) {
        return repository.save(newBand);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/bands/{id}")
    Optional<Band> one(@PathVariable Long id){
        return repository.findById(id);
    }

}
