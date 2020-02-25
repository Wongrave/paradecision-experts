package com.paradecision.propositions.groups;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {

    List<Group> findAllByPropositionId(Long propositionId);

}
