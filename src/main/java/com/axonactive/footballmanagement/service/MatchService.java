package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.MatchDao;
import com.axonactive.footballmanagement.dao.PlayerDao;
import com.axonactive.footballmanagement.service.dto.MatchDto;
import com.axonactive.footballmanagement.service.dto.PlayerDto;
import com.axonactive.footballmanagement.service.mapper.MatchMapper;
import com.axonactive.footballmanagement.service.mapper.PlayerMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Stateless
public class MatchService {
    @Inject
    private MatchDao matchDao;

    @Inject
    private MatchMapper matchMapper;

    public List<MatchDto> getMatchesByDate(String fromDate, String toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fromLocalDate = LocalDate.parse(fromDate, formatter);
        LocalDate toLocalDate = LocalDate.parse(toDate, formatter);
        return matchMapper.toDtos(matchDao.getMatchesByDate(fromLocalDate, toLocalDate));
    }
}
