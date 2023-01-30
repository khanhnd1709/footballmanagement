package com.axonactive.footballmanagement.dao;

import com.axonactive.footballmanagement.entities.GameEntity;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public interface GameDao {
    List<GameEntity> getMatchesByDate(LocalDateTime fromDate, LocalDateTime toDate);
}
