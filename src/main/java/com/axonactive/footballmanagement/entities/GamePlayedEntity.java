package com.axonactive.footballmanagement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "game_played",
        uniqueConstraints= @UniqueConstraint(columnNames={"player_id", "game_id"}))
@Data
public class GamePlayedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonBackReference
    private GameEntity game;

    @PositiveOrZero
    @Max(value = 120)
    private Integer timeIn;

    @PositiveOrZero
    @Max(value = 120)
    private Integer timeOut;

}
