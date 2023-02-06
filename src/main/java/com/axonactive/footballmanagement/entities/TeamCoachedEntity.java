package com.axonactive.footballmanagement.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;


@Entity
@Table(name = "team_coached")
@Data
public class TeamCoachedEntity implements IGenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "coach_id")
    private CoachEntity coach;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @PositiveOrZero
    private Long salary;

    @PastOrPresent
    private LocalDate attendDate;

    @PastOrPresent
    private LocalDate leaveDate;
}
