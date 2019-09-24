package com.paradecision.propositions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PropositionRepository extends JpaRepository<Proposition, Long> {

    List<Proposition> findAllByOrganizationId(Long organizationId);
    Optional<List<Proposition>> findAllByUserId(Long userId);

}
