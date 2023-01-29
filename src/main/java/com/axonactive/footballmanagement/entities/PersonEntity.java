package com.axonactive.footballmanagement.entities;

import com.axonactive.footballmanagement.enums.NationalityEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@MappedSuperclass
@Data
@NoArgsConstructor
public class PersonEntity {

    @NotNull
    @Size(max = 50)
    @Column(length = 50, nullable = false)
    protected String name;

    @Past
    protected LocalDate dob;

    @Size(max = 50)
    @Column(length = 50)
    @Enumerated(value = EnumType.STRING)
    protected NationalityEnum nationality;

    @Positive
    protected Integer height;

    @Positive
    protected Integer weight;
}
