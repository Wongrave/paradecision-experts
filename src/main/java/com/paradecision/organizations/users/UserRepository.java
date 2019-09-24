package com.paradecision.organizations.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsernameAndPassword(String userName, String password);
    User findUserByUsername(String userName);
    Optional<User> findByName(String name);

    Optional<User> findByUsername(String username);
}
