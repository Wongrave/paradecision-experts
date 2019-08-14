package com.paradecision.organizations;

import com.paradecision.organizations.units.BusinessUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
