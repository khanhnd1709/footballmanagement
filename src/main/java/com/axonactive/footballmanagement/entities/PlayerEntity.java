package com.axonactive.footballmanagement.entities;

import com.axonactive.footballmanagement.enums.FootednessEnum;
import com.axonactive.footballmanagement.enums.NationalityEnum;
import com.axonactive.footballmanagement.rest.request.PlayerRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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

    public PlayerEntity(PlayerRequest playerRequest) {
        this.name = playerRequest.getName();
        this.dob = playerRequest.getDob();
        this.nationalityEnum = playerRequest.getNationality();
        this.height = playerRequest.getHeight();
        this.weight = playerRequest.getWeight();
        this.footednessEnum = playerRequest.getFootedness();
    }
}
