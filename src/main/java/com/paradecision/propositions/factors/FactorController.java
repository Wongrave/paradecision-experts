package com.paradecision.propositions.factors;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/factors")
@AllArgsConstructor
public class FactorController {

    private final FactorRepository repository;

    @GetMapping("/all")
    List<Factor> allFactors() {
        return repository.findAll();
    }

    @GetMapping("/{propositionId}")
    List<Factor> factors(@PathVariable Long propositionId) {
        return repository.findAllByPropositionId(propositionId);
    }

    @PostMapping("/new")
    Factor newFactor(@RequestBody Factor newFactor) {
        return repository.save(newFactor);
    }

    @GetMapping("/{id}")
    Optional<Factor> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Factor update(@RequestBody Factor factor, @PathVariable Long id) {
        // Optional<Proposition> oldProposition = repository.findById(id);

        //if (!Proposition.isPresent())
        //  return ResponseEntity.notFound().build();

        factor.setId(id);

        return repository.save(factor);
    }

}
