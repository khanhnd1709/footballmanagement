package com.axonactive.footballmanagement.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class RecordEntity {

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer wins;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer loses;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer ties;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer numberOfGoals;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer getNumberOfGoalsConceded;

}
