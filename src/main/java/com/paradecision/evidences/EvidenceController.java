package com.paradecision.evidences;

import com.paradecision.organizations.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/evidences")
@AllArgsConstructor
public class EvidenceController {

    private final EvidenceRepository repository;
    private final UserRepository userRepository;


    @GetMapping("/all")
    List<Evidence> allEvidences() {
        return repository.findAll();
    }

    @GetMapping("/{userId}/{propositionId}")
    List<Evidence> evidences(@PathVariable Long propositionId, @PathVariable Long userId) {

        repository.generateEvidences(propositionId, userId);

        return repository.returnAllEvidencesFromUser(propositionId, userId);
    }

    @PostMapping("/new")
    Optional<Evidence> newEvidence(@RequestBody List<Evidence> newEvidences) {
        for(Evidence newEvidence : newEvidences) {
            repository.save(newEvidence);
        }
        return null;
    }

    @GetMapping("/{id}")
    Optional<Evidence> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Evidence update(@RequestBody Evidence evidence, @PathVariable Long id) {
        // Optional<Evidence> oldEvidence = repository.findById(id);

        //if (!evidence.isPresent())
          //  return ResponseEntity.notFound().build();

        evidence.setId(id);

        return repository.save(evidence);
    }




}
