package com.axonactive.footballmanagement.entities;

import com.axonactive.footballmanagement.enums.NationalityEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "coach")
@Data
public class CoachEntity {

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
}
