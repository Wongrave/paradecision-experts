package com.paradecision.organizations.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUserNameAndPassword(String userName, String password);
    User findUserByUserName(String userName);
    Optional<User> findByName(String name);

}
