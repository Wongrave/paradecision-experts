package com.paradecision.organizations.users;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{userName}")
    User one(@PathVariable String userName) {
        return repository.findUserByUserName(userName);
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
    ResponseEntity login(@RequestBody User user) {
        User existingUser = repository.findUserByUserNameAndPassword(user.getUserName(), user.getPassword());
        if (repository.existsById(existingUser.getId())) {
            return ResponseEntity.ok(existingUser);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }


}
