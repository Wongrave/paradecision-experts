package com.paradecision.organizations.users;


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
@Table(name = "user_02")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a02_id")
    private Long id;

    @NotNull
    @Column(name = "a02_name")
    private String name;

    @NotNull
    @Column(name = "a02_username")
    private String userName;

    @NotNull
    @Column(name = "a02_password")
    private String password;

    @NotNull
    @Column(name = "a02_email")
    private String email;

    @NotNull
    @Column(name = "a02_enabled")
    private boolean enabled;

    @NotNull
    @Column(name = "a02_role")
    private String role;

    @NotNull
    @Column(name = "a02_admin")
    private boolean admin;

    @NotNull
    @Column(name = "a02_master")
    private boolean master;

    @NotNull
    @Column(name = "a02_paradecision")
    private boolean paradecision;

    @NotNull
    @Column(name = "a02_authority")
    private String authority;

    @ManyToMany(mappedBy = "users")
    private List<Department> departments;

    public <T> User(String userName, String password, List<T> asList) {
    }
}
