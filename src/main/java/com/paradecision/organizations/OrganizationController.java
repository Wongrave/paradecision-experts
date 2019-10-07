package com.paradecision.organizations;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/organizations")
@AllArgsConstructor
public class OrganizationController {


    private final OrganizationRepository repository;

    @GetMapping("/all")
    List<Organization> allOrganizations() {
        return repository.findAll();
    }

//    @GetMapping("/{organizationId}/units")
//    List<Organization> businessUnits(@PathVariable Long organizationId) {
//        Optional<Organization> organization = repository.findById(organizationId);
//        organization
//
//    }

    @PostMapping("/new")
    Organization newOrganization(@RequestBody Organization newOrganization) {
        return repository.save(newOrganization);
    }

    @GetMapping("/{id}")
    Optional<Organization> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Organization update(@RequestBody Organization organization, @PathVariable Long id) {
        // Optional<Proposition> oldProposition = repository.findById(id);

        //if (!Proposition.isPresent())
        //  return ResponseEntity.notFound().build();

        organization.setId(id);

        return repository.save(organization);
    }

    @GetMapping("/fromUser/{userId}")
    List<Organization> fromUser(@PathVariable Long userId) {

        return repository.findAllByUser(userId);
    }

}
