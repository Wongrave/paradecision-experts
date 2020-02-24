package com.paradecision.propositions.profiles;

import com.paradecision.organizations.users.User;
import com.paradecision.organizations.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
@AllArgsConstructor
public class ProfileController {

    private final ProfileRepository repository;
    private final UserRepository userRepository;

    @GetMapping("/all")
    List<Profile> allProfile() {
        return repository.findAll();
    }

    @GetMapping("/{propositionId}")
    List<Profile> profiles(@PathVariable Long propositionId) {
        return repository.findAllByPropositionId(propositionId);
    }

    @GetMapping("/suggestedUsers/{organizationId}")
    List<User> suggestedUsers(@PathVariable Long organizationId){
        return userRepository.findAllUsersByOrganizationId(organizationId);
    }

    @PostMapping("/new")
    Profile newProfile(@RequestBody Profile newProfile) {
        newProfile.setAdmin(false);
        newProfile.setAnalyst(false);
        newProfile.setExpert(false);
        newProfile.setOwner(false);
        newProfile.setStatus(true);
        newProfile.setWeight(1);
        return repository.save(newProfile);
    }

    @PutMapping("/{id}")
    Profile update(@RequestBody Profile profile, @PathVariable Long id) {
        // Optional<Proposition> oldProposition = repository.findById(id);

        //if (!Proposition.isPresent())
        //  return ResponseEntity.notFound().build();

        profile.setId(id);

        return repository.save(profile);
    }

    @PutMapping("/changeAdmin/{id}")
    Profile changeAdmin(@RequestBody Boolean checked, @PathVariable Long id) {

        Profile profile = repository.getOne(id);

        profile.setAdmin(checked);

        return repository.save(profile);
    }

    @PutMapping("/changeExpert/{id}")
    Profile changeExpert(@RequestBody Boolean checked, @PathVariable Long id) {

        Profile profile = repository.getOne(id);

        profile.setExpert(checked);

        return repository.save(profile);
    }

    @PutMapping("/changeAnalyst/{id}")
    Profile changeAnalyst(@RequestBody Boolean checked, @PathVariable Long id) {

        Profile profile = repository.getOne(id);

        profile.setAnalyst(checked);

        return repository.save(profile);
    }

    @PostMapping("/delete/{id}")
    void deleteProfile(@PathVariable Long id) {
        repository.deleteById(id);
    }



}
