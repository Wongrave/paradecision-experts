package com.paradecision.propositions;

import com.paradecision.config.StringCryptoConverter;
import com.paradecision.propositions.factors.Factor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    @Convert(converter = StringCryptoConverter.class)
    private String description;

    @Column(name = "a14_description")
    private String analysisDescription;

    @Column(name = "a14_confidence")
    private BigDecimal analysisConfidence;

    @Column(name = "a14_contradiction")
    private BigDecimal analysisContradiction;

    @NotNull
    @Column(name = "a01_summary")
    @Convert(converter = StringCryptoConverter.class)
    private String summary;

    @NotNull
    @Column(name = "a01_date")
    private Date date;

    @Column(name = "a01_collection")
    @Convert(converter = StringCryptoConverter.class)
    private String collection;

    @OneToMany(mappedBy = "proposition", targetEntity = Factor.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Factor> factors;

}
