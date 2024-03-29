package com.paradecision.organizations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    @Query(
            value = "SELECT DISTINCT o.* " +
                    "FROM user_02 u " +
                    "JOIN user_department ud ON ud.a02_id = u.a02_id " +
                    "JOIN department_21 d ON d.a21_id = ud.a21_id " +
                    "JOIN businessunit_25 bu ON d.a25_id = bu.a25_id " +
                    "JOIN organization_20 o ON o.a20_id = bu.a20_id " +
                    "WHERE u.a02_id = :userId",
            nativeQuery = true)
    List<Organization> findAllByUser(Long userId);
}
