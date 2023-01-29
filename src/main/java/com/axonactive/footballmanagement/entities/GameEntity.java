package com.axonactive.footballmanagement.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "game")
@Data
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "home_id")
    private TeamEntity home;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "away_id")
    private TeamEntity away;

    @OneToMany(mappedBy = "game")
    private List<GamePlayedEntity> players;

    @OneToMany(mappedBy = "game")
    private List<GoalEntity> goals;

    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private StadiumEntity stadium;

    private LocalDateTime dateTimeOfGame;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "league_id")
    private LeagueEntity league;

}
