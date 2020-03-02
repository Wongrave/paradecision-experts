package com.paradecision.organizations.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsernameAndPassword(String userName, String password);
    User findUserByUsername(String userName);
    Optional<User> findByName(String name);

    Optional<User> findByUsername(String username);

    @Query(
            value = "SELECT DISTINCT u.* " +
                    "FROM user_02 u " +
                    "JOIN user_department ud ON ud.a02_id = u.a02_id " +
                    "JOIN department_21 d ON d.a21_id = ud.a21_id " +
                    "JOIN businessunit_25 bu ON d.a25_id = bu.a25_id " +
                    "JOIN organization_20 o ON o.a20_id = bu.a20_id " +
                    "JOIN proposition_01 p ON o.a20_id = p.a20_id " +
                    "WHERE p.a01_id = :propositionId " +
                    "NOT EXISTS (SELECT u.* " +
                        "FROM profile_11 pr " +
                        "WHERE u.a02_id = pr.a02_id " +
                        "AND pr.a01_id = :propositionId )",
            nativeQuery = true)
    List<User> findAllUsersByPropositionId(Long propositionId);

}
