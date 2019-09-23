package com.paradecision.organizations.users;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paradecision.organizations.departments.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user_02")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "a02_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "a02_name")
    private String name;

    @Column(name = "a02_username")
    private String userName;

    @NotNull
    @Column(name = "a02_password")
    private String password;

    @Column(name = "a02_email")
    private String email;

    @Column(name = "a02_enabled")
    private boolean enabled;

    @Column(name = "a02_role")
    private String role;

    @Column(name = "a02_admin")
    private boolean admin;

    @Column(name = "a02_master")
    private boolean master;

    @Column(name = "a02_paradecision")
    private boolean paradecision;


    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Role> authorities = new ArrayList<>();

    @ManyToMany(mappedBy = "users")
    private List<Department> departments;

    public <T> User(String userName, String password, List<T> asList) {
    }

    public User(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public List<String> getRoles() {
        return authorities.stream().map(Role::getRole).collect(Collectors.toList());
    }

    public boolean isInRole(Role.ROLES role) {
        return getRoles().contains(role.name());
    }

    public void addRole(Role.ROLES role) {
        this.authorities.add(new Role(role.asAuthority()));
    }
}