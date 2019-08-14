package com.paradecision.organizations.departments;

import com.paradecision.organizations.units.BusinessUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private String description;

    @NotNull
    @Column(name = "a21_summary")
    private String summary;

    @ManyToOne
    @JoinColumn(name = "a25_id")
    private BusinessUnit businessUnit;

}
