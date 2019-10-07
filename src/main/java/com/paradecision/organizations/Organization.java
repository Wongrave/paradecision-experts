package com.paradecision.organizations;

import com.paradecision.config.StringCryptoConverter;
import com.paradecision.organizations.units.BusinessUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "organization_20")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a20_id")
    private Long id;

    @NotNull
    @Column(name = "a20_description")
    @Convert(converter = StringCryptoConverter.class)
    private String description;

    @NotNull
    @Column(name = "a20_summary")
    @Convert(converter = StringCryptoConverter.class)
    private String summary;

    @NotNull
    @Column(name = "a20_active")
    private boolean active;

    @OneToMany(mappedBy = "organization", targetEntity = BusinessUnit.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BusinessUnit> businessUnits;

}
