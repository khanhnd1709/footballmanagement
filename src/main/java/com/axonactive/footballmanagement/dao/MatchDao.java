package com.axonactive.footballmanagement.dao;

import com.axonactive.footballmanagement.entities.MatchEntity;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;

@Stateless
public interface MatchDao {

    List<MatchEntity> getMatchesByDate(LocalDate fromDate, LocalDate toDate);
}
