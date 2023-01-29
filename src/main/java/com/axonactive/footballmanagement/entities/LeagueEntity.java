package com.axonactive.footballmanagement.entities;

import com.axonactive.footballmanagement.enums.NationalityEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "league")
@Data
public class LeagueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(length = 50, nullable = false, unique = true)
    @NotNull
    private String name;

    @Size(max = 50)
    @Column(length = 50)
    @Enumerated(value = EnumType.STRING)
    private NationalityEnum nationality;

    @NotNull
    @Min(value = 2)
    @Column(columnDefinition = "integer default 2")
    private Integer numberOfTeams;

    @Min(value = 20)
    @Column(columnDefinition = "integer default 20")
    private Integer maxPLayerEachTeam;

    @OneToMany(mappedBy = "league")
    private List<LeagueParticipatedEntity> teams;

    @OneToMany(mappedBy = "league")
    private List<GameEntity> games;

    @PastOrPresent
    private LocalDate startDate;

    @PastOrPresent
    private LocalDate endDate;
}
