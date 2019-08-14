package com.paradecision.propositions.sections;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sections")
@AllArgsConstructor
public class SectionController {

    private final SectionRepository repository;

    @GetMapping("/all")
    List<Section> allSections() {
        return repository.findAll();
    }

    @GetMapping("/{factorId}")
    List<Section> sections(@PathVariable Long factorId) {
        return repository.findAllByFactor(factorId);
    }

    @PostMapping("/new")
    Section newSection(@RequestBody Section newSection) {
        return repository.save(newSection);
    }

    @GetMapping("/{id}")
    Optional<Section> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Section update(@RequestBody Section section, @PathVariable Long id) {
        // Optional<Proposition> oldProposition = repository.findById(id);

        //if (!Proposition.isPresent())
        //  return ResponseEntity.notFound().build();

        section.setId(id);

        return repository.save(section);
    }


}
