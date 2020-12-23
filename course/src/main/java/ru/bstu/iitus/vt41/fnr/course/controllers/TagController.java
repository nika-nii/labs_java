package ru.bstu.iitus.vt41.fnr.course.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bstu.iitus.vt41.fnr.course.models.Tag;
import ru.bstu.iitus.vt41.fnr.course.repositories.TagRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class TagController {
    private final TagRepository repository;

    TagController(TagRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/tags")
    List<Tag> all(@RequestParam(required = false) String name) {
        if (name == null) {
            return repository.findAll();
        }
        return  repository.findTagByName(name);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/tags")
    Tag newTag(@RequestBody Tag newTag){
        return repository.save(newTag);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/tags/{id}")
    Optional<Tag> one(@PathVariable Long id){
        return repository.findById(id);
    }
}
