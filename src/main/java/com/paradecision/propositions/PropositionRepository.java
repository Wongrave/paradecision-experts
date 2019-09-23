package com.paradecision.propositions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropositionRepository extends JpaRepository<Proposition, Long> {

    List<Proposition> findAllByOrganizationId(Long organizationId);
    List<Proposition> findAllByUserId(Long userId);

}
