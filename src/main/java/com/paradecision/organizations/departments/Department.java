package com.paradecision.organizations.departments;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paradecision.config.StringCryptoConverter;
import com.paradecision.organizations.units.BusinessUnit;
import com.paradecision.organizations.users.User;
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
@Table(name = "department_21")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a21_id")
    private Long id;

    @NotNull
    @Column(name = "a21_description")
    @Convert(converter = StringCryptoConverter.class)
    private String description;

    @NotNull
    @Column(name = "a21_summary")
    @Convert(converter = StringCryptoConverter.class)
    private String summary;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "a25_id")
    private BusinessUnit businessUnit;

    @ManyToMany(mappedBy = "departments")
    private List<User> users;

}
