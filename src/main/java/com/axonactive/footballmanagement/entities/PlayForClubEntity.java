package com.axonactive.footballmanagement.entities;

import com.axonactive.footballmanagement.enums.PositionEnum;
import lombok.*;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Entity
@Table(name = "play_for_club")
@Data
public class PlayForClubEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity playerEntity;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private ClubEntity clubEntity;

    @Min(value = 0)
    @Max(value = 99)
    @Column(name = "number_shirt")
    private Integer numberShirt;

    @PositiveOrZero
    private Long salary;

    @PositiveOrZero
    private Long transferValue;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "position")
    private PositionEnum positionEnum;

    @Column(name = "start_date")
    @PastOrPresent
    private LocalDate startDate;

    @PastOrPresent
    private LocalDate endDate;

    
    private Boolean isActive;
}
