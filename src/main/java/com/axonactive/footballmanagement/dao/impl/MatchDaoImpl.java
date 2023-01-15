package com.axonactive.footballmanagement.dao.impl;

import com.axonactive.footballmanagement.dao.MatchDao;
import com.axonactive.footballmanagement.entities.MatchEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MatchDaoImpl implements MatchDao {

    @PersistenceContext(unitName = "football")
    EntityManager em;

    @Override
    public List<MatchEntity> getMatchesByDate(LocalDate fromDate, LocalDate toDate) {
        LocalDateTime fromDateTime = fromDate.atStartOfDay();
        LocalDateTime toDateTime = toDate.plusDays(1).atStartOfDay();

        return em.createQuery("SELECT m FROM MatchEntity m WHERE m.matchStartTime>=:fromDateTime" +
                        " AND m.matchStartTime<:toDateTime", MatchEntity.class)
                .setParameter("fromDateTime", fromDateTime)
                .setParameter("toDateTime", toDateTime)
                .getResultList();
    }
}
