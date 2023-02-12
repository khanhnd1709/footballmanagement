package com.axonactive.footballmanagement.entities;

import com.axonactive.footballmanagement.enums.NationalityEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name = "league")
public class LeagueEntity implements IGenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(length = 50, nullable = false, unique = true)
    @NotNull
    private String name;

    @Enumerated(value = EnumType.STRING)
    private NationalityEnum nationality;

    @NotNull
    @Min(value = 2)
    @Column(columnDefinition = "integer default 2")
    private Integer numberOfTeams;

    @Min(value = 20)
    @Column(columnDefinition = "integer default 20")
    private Integer maxActivePLayerEachTeam;

    @Min(value = 20)
    @Column(columnDefinition = "integer default 20")
    private Integer maxPLayerOneTeamEachGame;

    @Min(value = 3)
    @Column(columnDefinition = "integer default 3")
    private Integer maxNumberOfSubstituteEachGame;

    @OneToMany(mappedBy = "league")
    private List<SeasonEntity> seasons;
}
