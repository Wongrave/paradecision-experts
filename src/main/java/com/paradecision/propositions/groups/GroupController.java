package com.paradecision.propositions.groups;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groups")
@AllArgsConstructor
public class GroupController {

    private final GroupRepository repository;

    @GetMapping("/all")
    List<Group> allGroup() {
        return repository.findAll();
    }

    @GetMapping("/from/{propositionId}")
    List<Group> fromProposition(@PathVariable Long propositionId) {
        return repository.findAllByPropositionId(propositionId);
    }

    @PostMapping("/new")
    Group newGroup(@RequestBody Group newGroup) {
        return repository.save(newGroup);
    }

    @GetMapping("/{id}")
    Optional<Group> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Group updateGroup(@RequestBody Group group, @PathVariable Long id) {
        // Optional<Proposition> oldProposition = repository.findById(id);

        //if (!Proposition.isPresent())
        //  return ResponseEntity.notFound().build();

        group.setId(id);

        return repository.save(group);
    }

    @DeleteMapping("/delete/{id}")
    void deleteGroup(@PathVariable Long id) {

        repository.deleteById(id);
    }




}
