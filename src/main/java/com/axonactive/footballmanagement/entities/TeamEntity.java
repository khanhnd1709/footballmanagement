package com.axonactive.footballmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "team")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamEntity implements IGenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(length = 50, nullable = false)
    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private StadiumEntity stadium;

    @OneToMany(mappedBy = "team")
    private List<TeamPlayedEntity> players;
}