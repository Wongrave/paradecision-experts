package com.paradecision.organizations.users;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.paradecision.config.StringCryptoConverter;
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
    @Convert(converter = StringCryptoConverter.class)
    private String name;

    @Column(name = "a02_username")
    @Convert(converter = StringCryptoConverter.class)
    private String username;

    @NotNull
    @Column(name = "a02_password")
    @Convert(converter = StringCryptoConverter.class)
    private String password;

    @Column(name = "a02_email")
    @Convert(converter = StringCryptoConverter.class)
    private String email;

    @Column(name = "a02_enabled")
    private boolean enabled;

    @Column(name = "a02_role")
    @Convert(converter = StringCryptoConverter.class)
    private String role;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> authorities = new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany
    @JoinTable(
            name="user_department",
            joinColumns = @JoinColumn(name = "a02_id"),
            inverseJoinColumns = @JoinColumn(name = "a21_id")
    )
    private List<Department> departments;

    public <T> User(String username, String password, List<T> asList) {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return username;
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