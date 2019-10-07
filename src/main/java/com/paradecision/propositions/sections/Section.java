package com.paradecision.propositions.sections;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paradecision.propositions.factors.Factor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "section_06")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a06_id")
    private Long id;

    @NotNull
    @Column(name = "a06_tag")
    private String tag;

    @NotNull
    @Column(name = "a06_description")
    private String description;

    @NotNull
    @Column(name = "a06_summary")
    private String summary;

    @NotNull
    @Column(name = "a06_selected")
    private boolean selected;

    @ManyToOne
    @JoinColumn(name = "a04_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Factor factor;


}
