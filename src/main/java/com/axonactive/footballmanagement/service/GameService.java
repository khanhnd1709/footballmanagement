package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.GameDao;
import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.service.dto.GameDto;
import com.axonactive.footballmanagement.service.mapper.GameMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Stateless
public class GameService {
    @Inject
    private GameDao gameDao;

    @Inject
    private GameMapper gameMapper;

    public List<GameDto> getMatchesByDate(LocalDate fromLocalDate, LocalDate toLocalDate) {
        LocalDateTime fromLocalDateTime = LocalDateTime.of(LocalDate.from(fromLocalDate), LocalTime.of(0, 0, 0));
        LocalDateTime toLocalDateTime = LocalDateTime.of(LocalDate.from(toLocalDate), LocalTime.of(23, 59, 59));
        return gameMapper.toDtos(gameDao.getMatchesByDate(fromLocalDateTime, toLocalDateTime));
    }
}
