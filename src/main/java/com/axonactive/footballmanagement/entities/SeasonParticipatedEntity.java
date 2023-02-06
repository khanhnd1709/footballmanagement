package com.axonactive.footballmanagement.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "season_participated", uniqueConstraints = @UniqueConstraint(columnNames = {"team_id", "season_id"}))
public class SeasonParticipatedEntity implements IGenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "season_id")
    private SeasonEntity season;

    private Integer rank;

    private RecordEntity record;
}
