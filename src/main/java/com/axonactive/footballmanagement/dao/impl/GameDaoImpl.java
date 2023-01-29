package com.axonactive.footballmanagement.dao.impl;

import com.axonactive.footballmanagement.dao.GameDao;
import com.axonactive.footballmanagement.entities.GameEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class GameDaoImpl implements GameDao {

    @PersistenceContext(unitName = "football")
    EntityManager em;

    @Override
    public List<GameEntity> getMatchesByDate(LocalDate fromDate, LocalDate toDate) {
        return em.createQuery("SELECT g FROM GameEntity g WHERE g.dateTimeOfGame.toLocalDate()>=:fromDate" +
                        " AND m.dateTimeOfGame.toLocalDate()<=:toDate ORDER BY g.dateTimeOfGame", GameEntity.class)
                .setParameter("fromDate", fromDate)
                .setParameter("toDate", toDate)
                .getResultList();
    }
}
