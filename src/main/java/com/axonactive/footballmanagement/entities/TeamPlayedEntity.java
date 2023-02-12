package com.axonactive.footballmanagement.entities;

import com.axonactive.footballmanagement.enums.PositionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Entity
@Table(name = "team_played")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamPlayedEntity implements IGenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @Max(99)
    @PositiveOrZero
    private Integer numberShirt;

    @PositiveOrZero
    private Long salary;

    @PositiveOrZero
    private Long transferFee;

    @Enumerated(value = EnumType.STRING)
    private PositionEnum position;

    @PastOrPresent
    private LocalDate attendDate;

    @PastOrPresent
    private LocalDate leaveDate;

    private Boolean isActive;
}
