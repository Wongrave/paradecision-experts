package com.paradecision.propositions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "proposition_01")
public class Proposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a01_id")
    private Long id;

    @NotNull
    @Column(name = "a02_id")
    private Long userId;

    @NotNull
    @Column(name = "a20_id")
    private Long organizationId;

    @NotNull
    @Column(name = "a01_description")
    private String description;

    @Column(name = "a14_description")
    private String analysisDescription;

    @Column(name = "a14_confidence")
    private BigDecimal analysisConfidence;

    @Column(name = "a14_contradiction")
    private BigDecimal analysisContradiction;

    @NotNull
    @Column(name = "a01_summary")
    private String summary;

    @NotNull
    @Column(name = "a01_date")
    private Date date;

    @NotNull
    @Column(name = "a01_collection")
    private String collection;

}
