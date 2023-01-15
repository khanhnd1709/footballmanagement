package com.axonactive.footballmanagement.entities;

import com.axonactive.footballmanagement.enums.NationalityEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

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
    @Column(length = 50, name = "nationality")
    @Enumerated(value = EnumType.STRING)
    private NationalityEnum nationalityEnum;

    @PastOrPresent
    private LocalDate startDate;

    @PastOrPresent
    private LocalDate endDate;
}
