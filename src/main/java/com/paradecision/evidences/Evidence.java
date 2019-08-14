package com.paradecision.evidences;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.paradecision.propositions.factors.Factor;
import com.paradecision.propositions.sections.Section;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "evidence_07")
public class Evidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a07_id")
    private Long id;

    @NotNull
    @Column(name = "a01_id")
    private Long propositionId;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "a04_id")
    private Factor factor;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "a06_id")
    private Section section;

    @NotNull
    @Column(name = "a15_id")
    private Long userGroupRelationId;

    @NotNull
    @Column(name = "a11_id")
    private Long profileId;

    @NotNull
    @Column(name = "a05_id")
    private Long groupId;

    @NotNull
    @Positive
    @Column(name = "a07_mi")
    private BigDecimal favorable;

    @NotNull
    @Positive
    @Column(name = "a07_lambda")
    private BigDecimal desfavorable;

    @NotNull
    @Column(name = "a07_weight")
    private Integer weight;

    @Column(name = "a07_confirmed")
    private Boolean confirmed;


}
