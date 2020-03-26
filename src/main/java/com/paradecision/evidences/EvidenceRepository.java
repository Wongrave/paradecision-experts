package com.paradecision.evidences;

import com.paradecision.propositions.Proposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface EvidenceRepository extends JpaRepository<Evidence, Long> {

    List<Evidence> findAllByGroupId(Long groupId);

    List<Evidence> findByPropositionId(Long propositionId);

    @Query(
            value = "SELECT DISTINCT p.* " +
                    "FROM proposition_01 p " +
                    "JOIN profile_11 p11 ON p11.a01_id = p.a01_id " +
                    "WHERE p11.a02_id = :userId AND " +
                    "p.a20_id = :organizationId",
            nativeQuery = true)
    Optional<List<Proposition>> findAllByProfile(Long userId, Long organizationId);

    @Modifying
    @Query(
            value = "INSERT INTO evidence_07 (a04_id, a06_id, a11_id, a05_id, a01_id) " +
                    "SELECT DISTINCT f.a04_id, s.a06_id, p.a11_id, p.a05_id, :propositionId " +
                    "FROM factor_04 f, section_06 s, profile_11 p " +
                    "WHERE f.a04_id = s.a04_id " +
                    "AND f.a01_id = :propositionId " +
                    "AND f.a01_id = p.a01_id " +
                    "AND p.a11_expert = 1 " +
                    "AND p.a02_id = :userId " +
                    "AND p.a05_id IS NOT NULL " +
                    "AND s.a06_id NOT IN ( " +
                    "SELECT e.a06_id " +
                    "FROM evidence_07 e, profile_11 p " +
                    "WHERE e.a11_id = p.a11_id " +
                    "AND p.a02_id = :userId " +
                    "AND e.a06_id IS NOT NULL " +
                    ") " +
                    "UNION SELECT DISTINCT f.a04_id, NULL, p.a11_id, p.a05_id, :propositionId " +
                    "FROM factor_04 f, section_06 s, profile_11 p " +
                    "WHERE f.a01_id = :propositionId AND f.a01_id = p.a01_id " +
                    "AND p.a11_expert = 1 " +
                    "AND p.a02_id = :userId " +
                    "AND p.a05_id IS NOT NULL " +
                    "AND f.a04_id NOT IN ( " +
                    "SELECT DISTINCT f.a04_id " +
                    "FROM factor_04 f, section_06 s " +
                    "WHERE f.a04_id = s.a04_id " +
                    "AND f.a01_id = :propositionId ) " +
                    "AND f.a04_id NOT IN ( " +
                    "SELECT DISTINCT e.a04_id " +
                    "FROM evidence_07 e, profile_11 p " +
                    "WHERE e.a11_id = p.a11_id " +
                    "AND p.a02_id = :userId) ",
            nativeQuery = true)
    @Transactional
    void generateEvidences(@Param("propositionId") Long propositionId, @Param("userId") Long userId);

    @Query(
            value = "SELECT DISTINCT e.a07_id, e.a07_confirmed, e.a07_lambda, e.a07_mi, e.a05_id, e.a11_id, e.a01_id, e.a07_weight, e.a04_id, e.a06_id " +
                    "FROM evidence_07 e, profile_11 p " +
                    "WHERE e.a01_id = :propositionId " +
                    "AND e.a11_id = p.a11_id " +
                    "AND p.a02_id = :userId ",
            nativeQuery = true)
    List<Evidence> returnAllEvidencesFromUser(Long propositionId, Long userId);
}
