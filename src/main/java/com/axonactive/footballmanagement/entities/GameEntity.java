package com.axonactive.footballmanagement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "game")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonManagedReference
    private List<GamePlayedEntity> players;

    @OneToMany(mappedBy = "game")
    @JsonManagedReference
    private List<GoalEntity> goals;

    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private StadiumEntity stadium;

    private LocalDateTime dateTimeOfGame;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "league_id")
    @JsonBackReference
    private LeagueEntity league;

}
