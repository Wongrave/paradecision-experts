package com.paradecision.propositions.factors;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactorRepository extends JpaRepository<Factor, Long> {

    List<Factor> findAllByPropositionId(Long propositionId);

}
