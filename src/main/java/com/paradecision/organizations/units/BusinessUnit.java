package com.paradecision.organizations.units;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paradecision.config.StringCryptoConverter;
import com.paradecision.organizations.Organization;
import com.paradecision.organizations.departments.Department;
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
@Table(name = "businessunit_25")
public class BusinessUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a25_id")
    private Long id;


    @NotNull
    @Column(name = "a25_description")
    @Convert(converter = StringCryptoConverter.class)
    private String description;

    @NotNull
    @Column(name = "a25_summary")
    @Convert(converter = StringCryptoConverter.class)
    private String summary;

    @NotNull
    @Column(name = "a25_local")
    @Convert(converter = StringCryptoConverter.class)
    private String local;

    @ManyToOne
    @JoinColumn(name = "a20_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Organization organization;


    @OneToMany(mappedBy = "businessUnit", targetEntity = Department.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Department> departments;

}
