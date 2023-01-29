package com.axonactive.footballmanagement.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class RecordEntity {

    @NotNull
    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer wins;

    @NotNull
    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer loses;

    @NotNull
    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer ties;

    @NotNull
    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer numberOfGoals;

    @NotNull
    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer getNumberOfGoalsConceded;

}
