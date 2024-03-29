package com.paradecision.evidences;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.paradecision.propositions.factors.Factor;
import com.paradecision.propositions.sections.Section;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "evidence_07")
public class Evidence implements Cloneable {

    public Evidence(BigDecimal favorable, BigDecimal unfavorable, Factor factor){
        this.setFavorable(favorable);
        this.setUnfavorable(unfavorable);
        this.setFactor(factor);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a07_id")
    private Long id;

    @NotNull
    @Column(name = "a01_id")
    private Long propositionId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "a04_id")
    private Factor factor;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "a06_id")
    private Section section;

    @NotNull
    @Column(name = "a11_id")
    private Long profileId;

    @NotNull
    @Column(name = "a05_id")
    private Long groupId;

    @NotNull
    @Column(name = "a07_mi")
    private BigDecimal favorable;

    @NotNull
    @Column(name = "a07_lambda")
    private BigDecimal unfavorable;

    @NotNull
    @Column(name = "a07_weight")
    private Integer weight;

    @Column(name = "a07_confirmed")
    private Boolean confirmed;


}
