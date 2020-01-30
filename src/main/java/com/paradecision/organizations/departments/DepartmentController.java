package com.paradecision.organizations.departments;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentRepository repository;

    @GetMapping("/all")
    List<Department> allDepartments() {
        return repository.findAll();
    }

//    @GetMapping("/{organizationId}/units")
//    List<Organization> businessUnits(@PathVariable Long organizationId) {
//        Optional<Organization> organization = repository.findById(organizationId);
//        organization
//
//    }

    @PostMapping("/new")
    Department newDepartment(@RequestBody Department newDepartment) {
        return repository.save(newDepartment);
    }

    @GetMapping("/{id}")
    Optional<Department> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Department update(@RequestBody Department department, @PathVariable Long id) {
        // Optional<Proposition> oldProposition = repository.findById(id);

        //if (!Proposition.isPresent())
        //  return ResponseEntity.notFound().build();

        department.setId(id);

        return repository.save(department);
    }

    @PostMapping("/delete/{id}")
    void deleteDepartment(@PathVariable Long id) {
        repository.deleteById(id);
    }


}