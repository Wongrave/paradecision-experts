package com.paradecision.propositions;

import com.paradecision.organizations.users.UserRepository;
import com.paradecision.propositions.factors.FactorRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/propositions")
@AllArgsConstructor
public class PropositionController {

    private final PropositionRepository repository;
    private final UserRepository userRepository;
    private final FactorRepository factorRepository;

    @GetMapping("/all")
    List<Proposition> allPropositions() {
        return repository.findAll();
    }

    @GetMapping("/from/{organizationId}")
    List<Proposition> propositions(@PathVariable Long organizationId) {
        return repository.findAllByOrganizationId(organizationId);
    }

    @GetMapping("/fromUser/{userId}")
    Optional<List<Proposition>> propositionsFromUser(@PathVariable Long userId) {
        return repository.findAllByUserId(userId);
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

    @PostMapping("/delete/{id}")
    void deleteProposition(@PathVariable Long id) {

        repository.deleteById(id);
    }




}
