package com.axonactive.footballmanagement.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "participate_in_league", uniqueConstraints=
@UniqueConstraint(columnNames={"club_id", "league_id"}))
public class ParticipateInLeagueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "club_id")
    private ClubEntity clubEntity;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "league_id")
    private LeagueEntity leagueEntity;
}
