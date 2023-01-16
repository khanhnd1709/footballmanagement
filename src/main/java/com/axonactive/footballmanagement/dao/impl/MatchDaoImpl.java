package com.axonactive.footballmanagement.dao.impl;

import com.axonactive.footballmanagement.dao.MatchDao;
import com.axonactive.footballmanagement.entities.MatchEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class MatchDaoImpl implements MatchDao {

    @PersistenceContext(unitName = "football")
    EntityManager em;

    @Override
    public List<MatchEntity> getMatchesByDate(LocalDate fromDate, LocalDate toDate) {

        return em.createQuery("SELECT m FROM MatchEntity m WHERE m.matchStartTime>=:fromDateTime" +
                        " AND m.matchStartTime<=:toDateTime", MatchEntity.class)
                .setParameter("fromDateTime", fromDate)
                .setParameter("toDateTime", toDate)
                .getResultList();
    }
}
