package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.GameDao;
import com.axonactive.footballmanagement.entities.GameEntity;
import com.axonactive.footballmanagement.service.dto.GameDto;
import com.axonactive.footballmanagement.service.mapper.GameMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Stateless
public class GameService extends GenericService<GameEntity> {
    @Inject
    private GameDao gameDao;

    @Inject
    private GameMapper gameMapper;

    public GameService() {
        super(GameEntity.class);
    }

    public List<GameDto> findGamesByDate(LocalDate fromLocalDate, LocalDate toLocalDate) {
        LocalDateTime fromLocalDateTime = LocalDateTime.of(LocalDate.from(fromLocalDate), LocalTime.of(0, 0, 0));
        LocalDateTime toLocalDateTime = LocalDateTime.of(LocalDate.from(toLocalDate), LocalTime.of(23, 59, 59));
        return gameMapper.toDtos(gameDao.findGameByDate(fromLocalDateTime, toLocalDateTime));
    }
}
