package com.paradecision.organizations.users;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserRepository repository;

    @GetMapping("/all")
    List<User> allUsers() {
        return repository.findAll();
    }

//    @GetMapping("/{organizationId}/units")
//    List<Organization> businessUnits(@PathVariable Long organizationId) {
//        Optional<Organization> organization = repository.findById(organizationId);
//        organization
//
//    }

    @PostMapping("/new")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @GetMapping("/{id}")
    Optional<User> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    User update(@RequestBody User user, @PathVariable Long id) {
        // Optional<Proposition> oldProposition = repository.findById(id);

        //if (!Proposition.isPresent())
        //  return ResponseEntity.notFound().build();

        user.setId(id);

        return repository.save(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    User login(@RequestParam String userName, @RequestParam String password) {
        return repository.findUserByUserNameAndPassword(userName, password);
    }


}
