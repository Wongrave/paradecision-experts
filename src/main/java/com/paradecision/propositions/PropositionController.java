package com.paradecision.propositions;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/propositions")
@AllArgsConstructor
public class PropositionController {

    private final PropositionRepository repository;

    @GetMapping("/all")
    List<Proposition> allPropositions() {
        return repository.findAll();
    }

    @GetMapping("/from/{organizationId}")
    List<Proposition> propositions(@PathVariable Long organizationId) {
        return repository.findAllByOrganizationId(organizationId);
    }

    @PostMapping("/new")
    Proposition newProposition(@RequestBody Proposition newProposition) {
        return repository.save(newProposition);
    }

    @GetMapping("/{id}")
    Optional<Proposition> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Proposition update(@RequestBody Proposition proposition, @PathVariable Long id) {
        // Optional<Proposition> oldProposition = repository.findById(id);

        //if (!Proposition.isPresent())
        //  return ResponseEntity.notFound().build();

        proposition.setId(id);

        return repository.save(proposition);
    }




}
