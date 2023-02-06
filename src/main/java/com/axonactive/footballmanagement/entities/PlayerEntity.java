package com.axonactive.footballmanagement.entities;

import com.axonactive.footballmanagement.enums.FootednessEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "player")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity extends PersonEntity implements IGenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private FootednessEnum footedness;

    @OneToMany(mappedBy = "player")
    private List<TeamPlayedEntity> teams;

}
