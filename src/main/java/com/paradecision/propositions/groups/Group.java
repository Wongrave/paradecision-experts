package com.paradecision.propositions.groups;

import com.paradecision.config.StringCryptoConverter;
import com.paradecision.propositions.profiles.Profile;
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
@Table(name = "group_05")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a05_id")
    private Long id;

    @NotNull
    @Column(name = "a01_id")
    private Long propositionId;

    @NotNull
    @Column(name = "a05_description")
    @Convert(converter = StringCryptoConverter.class)
    private String description;

    @Column(name = "a05_summary")
    private String summary;

    @OneToMany(mappedBy = "group", targetEntity = Profile.class, fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<Profile> profiles;

}
