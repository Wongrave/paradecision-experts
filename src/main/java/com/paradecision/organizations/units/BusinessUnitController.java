package com.paradecision.organizations.units;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/businessunits")
@AllArgsConstructor
public class BusinessUnitController {

    private final BusinessUnitRepository repository;

    @GetMapping("/all")
    List<BusinessUnit> allBusinessUnits() {
        return repository.findAll();
    }

//    @GetMapping("/{organizationId}/units")
//    List<Organization> businessUnits(@PathVariable Long organizationId) {
//        Optional<Organization> organization = repository.findById(organizationId);
//        organization
//
//    }

    @PostMapping("/new")
    BusinessUnit newUser(@RequestBody BusinessUnit newBusinessUnit) {
        return repository.save(newBusinessUnit);
    }

    @PutMapping("/{id}")
    BusinessUnit update(@RequestBody BusinessUnit businessUnit, @PathVariable Long id) {
        // Optional<Proposition> oldProposition = repository.findById(id);

        //if (!Proposition.isPresent())
        //  return ResponseEntity.notFound().build();

        businessUnit.setId(id);

        return repository.save(businessUnit);
    }

    @GetMapping("/fromOrganization/{propositionId}")
    List<BusinessUnit> businessUnits(@PathVariable Long organizationId) {
        return repository.findAllByOrganizationId(organizationId);
    }


    @PostMapping("/delete/{id}")
    void deleteBusinessUnit(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
