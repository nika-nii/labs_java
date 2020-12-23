package ru.bstu.iitus.vt41.fnr.course.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bstu.iitus.vt41.fnr.course.models.Element;
import ru.bstu.iitus.vt41.fnr.course.repositories.ElementRepository;

import java.util.List;
import java.util.Optional;

import static java.lang.Long.parseLong;

@RestController
public class ElementController {
    private final ElementRepository repository;

    ElementController(ElementRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/elements")
    List<Element> all(@RequestParam(name="tag_id", required = false) Long tag_id) {
        return repository.findElementByTags_Id(tag_id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/elements")
    Element newElement(@RequestBody Element newElement){
        return repository.save(newElement);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/elements/{id}")
    Optional<Element> one(@PathVariable Long id){
        return repository.findById(id);
    }
}
