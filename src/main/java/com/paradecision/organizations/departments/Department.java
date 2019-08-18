package com.paradecision.organizations.departments;

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
    private String description;

    @NotNull
    @Column(name = "a21_summary")
    private String summary;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "a25_id")
    private BusinessUnit businessUnit;

    @ManyToMany
    @JoinTable(
            name="department_user",
            joinColumns = @JoinColumn(name = "a21_id"),
            inverseJoinColumns = @JoinColumn(name = "a02_id")
    )
    private List<User> users;

}
