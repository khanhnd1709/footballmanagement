package com.axonactive.footballmanagement.entities;

import com.axonactive.footballmanagement.enums.FootednessEnum;
import com.axonactive.footballmanagement.enums.NationalityEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "player")
@Data
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(length = 50, nullable = false)
    @NotNull
    private String name;

    @Past
    private LocalDate dob;

    @Size(max = 50)
    @Column(length = 50, name = "nationality")
    @Enumerated(value = EnumType.STRING)
    private NationalityEnum nationalityEnum;

    @Positive
    private Integer height;

    @Positive
    private Integer weight;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "footedness")
    private FootednessEnum footednessEnum;
}
