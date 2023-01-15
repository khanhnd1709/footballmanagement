package com.axonactive.footballmanagement.dao.impl;

import com.axonactive.footballmanagement.dao.PlayerDao;
import com.axonactive.footballmanagement.entities.PlayForClubEntity;
import com.axonactive.footballmanagement.entities.PlayerEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PlayerDaoImpl implements PlayerDao {

    @PersistenceContext(unitName = "football")
    EntityManager em;

    @Override
    public PlayForClubEntity getPlayerById(Long id) {
        return em.createQuery("SELECT pfc FROM PlayForClubEntity pfc WHERE pfc.playerEntity.id=:id" +
                        " AND pfc.isActive=TRUE", PlayForClubEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<PlayForClubEntity> getAllPlayers() {
        return em.createQuery("SELECT pfc FROM PlayForClubEntity pfc WHERE pfc.isActive=TRUE", PlayForClubEntity.class)
                .getResultList();
    }

}
