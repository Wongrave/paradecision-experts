package com.paradecision.propositions.profiles;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profiles")
@AllArgsConstructor
public class ProfileController {

    private final ProfileRepository repository;

    @GetMapping("/all")
    List<Profile> allProfile() {
        return repository.findAll();
    }

    @GetMapping("/{propositionId}")
    List<Profile> profiles(@PathVariable Long propositionId) {
        return repository.findAllByPropositionId(propositionId);
    }

    @PostMapping("/new")
    Profile newProfile(@RequestBody Profile newProfile) {
        return repository.save(newProfile);
    }

    @GetMapping("/{id}")
    Optional<Profile> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Profile update(@RequestBody Profile profile, @PathVariable Long id) {
        // Optional<Proposition> oldProposition = repository.findById(id);

        //if (!Proposition.isPresent())
        //  return ResponseEntity.notFound().build();

        profile.setId(id);

        return repository.save(profile);
    }

    @PostMapping("/delete/{id}")
    void deleteProfile(@PathVariable Long id) {
        repository.deleteById(id);
    }



}
