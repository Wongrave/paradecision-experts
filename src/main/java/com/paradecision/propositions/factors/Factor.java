package com.paradecision.propositions.factors;

import com.paradecision.propositions.Proposition;
import com.paradecision.propositions.sections.Section;
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
@Table(name = "factor_04")
public class Factor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a04_id")
    private Long id;

    @NotNull
    @Column(name = "a04_tag")
    private String tag;

    @NotNull
    @Column(name = "a04_description")
    private String description;

    @NotNull
    @Column(name = "a04_summary")
    private String summary;

    @NotNull
    @Column(name = "a04_selected")
    private boolean selected;

    @ManyToOne
    @JoinColumn(name = "a01_id")
    private Proposition proposition;

    @OneToMany(mappedBy = "factor", targetEntity = Section.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Section> sections;
}
