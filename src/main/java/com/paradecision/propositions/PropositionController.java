package com.paradecision.propositions;

import com.paradecision.organizations.users.UserRepository;
import com.paradecision.propositions.factors.FactorRepository;
import com.paradecision.propositions.profiles.Profile;
import com.paradecision.propositions.profiles.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/propositions")
@AllArgsConstructor
public class PropositionController {

    private final PropositionRepository repository;
    private final ProfileRepository profileRepository;
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

    @GetMapping("/fromUser/{organizationId}/{userId}")
    Optional<List<Proposition>> propositionsFromUser(@PathVariable Long userId, @PathVariable Long organizationId) {
        return repository.findAllByProfile(userId, organizationId);
    }

    @PostMapping("/new")
    Proposition newProposition(@RequestBody Proposition newProposition) {
        Proposition proposition = repository.save(newProposition);
        String name = userRepository.getOne(proposition.getUserId()).getName();
        Profile newProfile = new Profile();
        newProfile.setName(name);
        newProfile.setWeight(1);
        newProfile.setStatus(true);
        newProfile.setOwner(true);
        newProfile.setExpert(false);
        newProfile.setAnalyst(false);
        newProfile.setAdmin(true);
        newProfile.setPropositionId(proposition.getId());
        newProfile.setUserId(proposition.getUserId());
        profileRepository.save(newProfile);
        return proposition;
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

    @DeleteMapping("/delete/{id}")
    void deleteProposition(@PathVariable Long id) {

        repository.deleteById(id);
    }




}
