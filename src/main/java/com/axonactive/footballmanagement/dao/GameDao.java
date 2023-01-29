package com.axonactive.footballmanagement.dao;

import com.axonactive.footballmanagement.entities.GameEntity;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;

@Stateless
public interface GameDao {
    List<GameEntity> getMatchesByDate(LocalDate fromDate, LocalDate toDate);
}
