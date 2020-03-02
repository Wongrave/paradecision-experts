package com.paradecision.propositions.profiles;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    List<Profile> findAllByPropositionId(Long propositionId);



}
