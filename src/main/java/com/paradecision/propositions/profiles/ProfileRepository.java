package com.paradecision.propositions.profiles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    List<Profile> findAllByPropositionId(Long propositionId);

    @Query(
            value = "SELECT DISTINCT p.a11_id, p.a11_admin, p.a11_analyst, p.a11_expert, " +
                    "p.a11_owner, p.a01_id, p.a11_status, p.a02_id, p.a11_weight, p.a02_name, p.a05_id " +
                    "FROM profile_11 p  " +
                    "WHERE p.a01_id = :propositionId " +
                    "AND p.a11_expert = 1 " +
                    "AND p.a05_id IS NULL ",
            nativeQuery = true)
    List<Profile> returnSuggestedProfiles(Long propositionId);


}
