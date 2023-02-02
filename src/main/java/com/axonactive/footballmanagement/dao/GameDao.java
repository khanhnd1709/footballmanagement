package com.axonactive.footballmanagement.dao;

import com.axonactive.footballmanagement.entities.GameEntity;

import javax.ejb.Stateless;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public interface GameDao extends GenericDao<GameEntity> {
    List<GameEntity> findGameByDate(LocalDateTime fromDate, LocalDateTime toDate);
}
