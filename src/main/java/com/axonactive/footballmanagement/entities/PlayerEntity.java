package com.axonactive.footballmanagement.entities;

import com.axonactive.footballmanagement.enums.FootednessEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "player")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity extends PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private FootednessEnum footedness;

    @OneToMany(mappedBy = "player")
    @JsonManagedReference
    private List<TeamPlayedEntity> teams;

}
