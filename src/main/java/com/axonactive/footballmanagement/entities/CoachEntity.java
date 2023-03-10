package com.axonactive.footballmanagement.entities;

import com.axonactive.footballmanagement.enums.AccrLevelEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Entity
@Table(name = "coach")
@Data
public class CoachEntity extends PersonEntity implements IGenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AccrLevelEnum accrLevel;

    @PositiveOrZero
    private Integer experience;

    @OneToMany(mappedBy = "coach")
    private List<TeamCoachedEntity> teams;
}
