package com.paradecision.propositions.profiles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paradecision.config.StringCryptoConverter;
import com.paradecision.propositions.groups.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "profile_11")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a11_id")
    private Long id;

    @NotNull
    @Column(name = "a01_id")
    private Long propositionId;

    @NotNull
    @Column(name = "a02_id")
    private Long userId;

    @Column(name = "a02_name")
    @Convert(converter = StringCryptoConverter.class)
    private String name;

    @NotNull
    @Column(name = "a11_weight")
    private Integer weight;

    @NotNull
    @Column(name = "a11_admin")
    private boolean admin;

    @NotNull
    @Column(name = "a11_expert")
    private boolean expert;

    @NotNull
    @Column(name = "a11_analyst")
    private boolean analyst;

    @NotNull
    @Column(name = "a11_status")
    private boolean status;

    @NotNull
    @Column(name = "a11_owner")
    private boolean owner;

    @ManyToOne
    @JoinColumn(name = "a05_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Group group;

}
