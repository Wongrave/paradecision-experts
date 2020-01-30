package com.paradecision.organizations.units;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessUnitRepository extends JpaRepository<BusinessUnit, Long> {

    List<BusinessUnit> findAllByOrganizationId(Long organizationId);
}
