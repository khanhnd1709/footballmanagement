package com.axonactive.footballmanagement.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stadium")
@Data
public class StadiumEntity implements IGenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(length = 50, nullable = false)
    @NotNull
    private String name;

    @Size(max = 200)
    @Column(length = 200)
    private String address;
}
