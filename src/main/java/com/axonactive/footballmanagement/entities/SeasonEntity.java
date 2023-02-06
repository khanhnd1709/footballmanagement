package com.axonactive.footballmanagement.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "season")
@Data
public class SeasonEntity implements IGenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "league_id")
    private LeagueEntity leagueEntity;

    @OneToMany(mappedBy = "season")
    private List<SeasonParticipatedEntity> teams;

    @OneToMany(mappedBy = "season")
    private List<GameEntity> games;

    private LocalDate startDate;

    private LocalDate endDate;
}
