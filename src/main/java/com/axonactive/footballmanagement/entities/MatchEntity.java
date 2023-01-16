package com.axonactive.footballmanagement.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "football_match", uniqueConstraints=
@UniqueConstraint(columnNames={"league_id", "club1_id", "club2_id"}))
@Data
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "league_id")
    @NotNull
    private LeagueEntity leagueEntity;

    @ManyToOne
    @JoinColumn(name = "club1_id")
    @NotNull
    private ClubEntity club1Entity;

    @ManyToOne
    @JoinColumn(name = "club2_id")
    @NotNull
    private ClubEntity club2Entity;

    @PositiveOrZero
    @Column(columnDefinition = "integer default 0")
    private Integer numberGoalClub1;

    @PositiveOrZero
    @Column(columnDefinition = "integer default 0")
    private Integer numberGoalClub2;

    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private StadiumEntity stadiumEntity;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate matchStartTime;
}
