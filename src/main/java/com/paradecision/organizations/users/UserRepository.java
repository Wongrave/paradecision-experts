package com.paradecision.organizations.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUserNameAndPassword(String userName, String password);
    User findUserByUserName(String userName);

}
