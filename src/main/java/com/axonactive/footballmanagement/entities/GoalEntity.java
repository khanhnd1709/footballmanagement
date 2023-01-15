package com.axonactive.footballmanagement.entities;

import com.axonactive.footballmanagement.enums.StyleEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Entity
@Table(name = "goal")
@Data
public class GoalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_id")
    @NotNull
    private MatchEntity matchEntity;

    @ManyToOne
    @JoinColumn(name = "player_score_id")
    @NotNull
    private PlayerEntity playerScoreEntity;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "style")
    private StyleEnum styleEnum;

    @ManyToOne
    @JoinColumn(name = "player_assist_id")
    private PlayerEntity playerAssistEntity;

    @Min(value = 0)
    @Max(value = 120)
    private Integer time;
}
