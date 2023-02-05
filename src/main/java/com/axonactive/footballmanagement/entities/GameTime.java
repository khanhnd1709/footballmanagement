package com.axonactive.footballmanagement.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Embeddable
@Data
public class GameTime {

    @NotNull
    @Column(nullable = false)
    @PositiveOrZero
    @Max(120)
    private Integer min;

    @PositiveOrZero
    @Max(59)
    private Integer sec;

    @PositiveOrZero
    private Integer extraMin;

    public void setExtraMin(Integer extraMin) {
        if (min == 45 || min == 90 || min == 105 || min == 120) this.extraMin = extraMin;
    }
}
