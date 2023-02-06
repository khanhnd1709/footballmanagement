package com.axonactive.footballmanagement.entities;

import com.axonactive.footballmanagement.enums.GoalTypeEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "goal")
@Data
public class GoalEntity implements IGenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "score_player_id")
    private PlayerEntity scorePlayer;

    @Enumerated(value = EnumType.STRING)
    private GoalTypeEnum goalType;

    @ManyToOne
    @JoinColumn(name = "assist_player_id")
    private PlayerEntity assistPlayer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @NotNull
    private GameTime timeOfGoal;

}
