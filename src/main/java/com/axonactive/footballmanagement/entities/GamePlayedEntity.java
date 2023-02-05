package com.axonactive.footballmanagement.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "game_played", uniqueConstraints = @UniqueConstraint(columnNames = {"player_id", "game_id"}))
@Data
public class GamePlayedEntity implements IGenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;

    @PositiveOrZero
    @Max(value = 120)
    private Integer timeIn;

    @PositiveOrZero
    @Max(value = 120)
    private Integer timeOut;

}
