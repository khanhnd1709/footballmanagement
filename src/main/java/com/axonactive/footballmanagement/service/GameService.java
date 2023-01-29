package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.GameDao;
import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.service.dto.GameDto;
import com.axonactive.footballmanagement.service.mapper.GameMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Stateless
public class GameService {
    @Inject
    private GameDao gameDao;

    @Inject
    private GameMapper gameMapper;

    public GameService() {
    }

    public List<GameDto> getMatchesByDate(String fromDate, String toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fromLocalDate = LocalDate.parse(fromDate, formatter);
        LocalDate toLocalDate = LocalDate.parse(toDate, formatter);
        return gameMapper.toDtos(gameDao.getMatchesByDate(fromLocalDate, toLocalDate));
    }
}
