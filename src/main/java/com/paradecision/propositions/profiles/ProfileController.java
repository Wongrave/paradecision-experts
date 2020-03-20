package com.paradecision.propositions.profiles;

import com.paradecision.organizations.users.UserRepository;
import com.paradecision.propositions.groups.Group;
import com.paradecision.propositions.groups.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
@AllArgsConstructor
public class ProfileController {

    private final ProfileRepository repository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    @GetMapping("/all")
    List<Profile> allProfile() {
        return repository.findAll();
    }

    @GetMapping("/from/{propositionId}")
    List<Profile> profiles(@PathVariable Long propositionId) {
        return repository.findAllByPropositionId(propositionId);
    }

    @GetMapping("/suggestedUsers/{propositionId}")
    List<Profile> suggestedUsers(@PathVariable Long propositionId){
        return repository.returnSuggestedProfiles(propositionId);
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
    Profile changeAdmin(@RequestBody Profile newProfile, @PathVariable Long id) {

        Profile profile = repository.getOne(id);

        profile.setAdmin(newProfile.isAdmin());

        return repository.save(profile);
    }

    @PutMapping("/changeExpert/{id}")
    Profile changeExpert(@RequestBody Profile newProfile, @PathVariable Long id) {

        Profile profile = repository.getOne(id);

        profile.setExpert(newProfile.isExpert());

        return repository.save(profile);
    }

    @PutMapping("/changeAnalyst/{id}")
    Profile changeAnalyst(@RequestBody Profile newProfile, @PathVariable Long id) {

        Profile profile = repository.getOne(id);

        profile.setAnalyst(newProfile.isAnalyst());

        return repository.save(profile);
    }

    @PutMapping("/addToGroup/{profileId}/{id}")
    Profile addToGroup(@PathVariable Long profileId, @PathVariable Long id) {

        Profile profile = repository.getOne(profileId);
        Group group = groupRepository.getOne(id);
        profile.setGroup(group);

        return repository.save(profile);
    }

    @DeleteMapping("/delete/{id}")
    void deleteProfile(@PathVariable Long id) {
        repository.deleteById(id);
    }



}
