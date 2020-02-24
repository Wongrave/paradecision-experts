package com.paradecision.propositions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PropositionRepository extends JpaRepository<Proposition, Long> {

    List<Proposition> findAllByOrganizationId(Long organizationId);
    Optional<List<Proposition>> findAllByUserId(Long userId);

    @Query(
            value = "SELECT DISTINCT p.* " +
                    "FROM proposition_01 p " +
                    "JOIN profile_11 p11 ON p11.a01_id = p.a01_id " +
                    "WHERE p11.a02_id = :userId AND " +
                    "p.a20_id = :organizationId",
            nativeQuery = true)
    Optional<List<Proposition>> findAllByProfile(Long userId, Long organizationId);

}
