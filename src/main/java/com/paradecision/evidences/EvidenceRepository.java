package com.paradecision.evidences;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvidenceRepository extends JpaRepository<Evidence, Long> {

    List<Evidence> findByPropositionId(Long propositionId);





}
