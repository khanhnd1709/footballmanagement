package com.axonactive.footballmanagement.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;


@Entity
@Table(name = "coach_for_club")
@Data
public class CoachForClubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "coach_id")
    private CoachEntity coachEntity;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "club_id")
    private ClubEntity clubEntity;

    @PositiveOrZero
    private Long salary;

    @Column(name = "start_date")
    @PastOrPresent
    private LocalDate startDate;

    @PastOrPresent
    private LocalDate endDate;
}
