package com.axonactive.footballmanagement.dao.impl;

import com.axonactive.footballmanagement.dao.PlayerDao;
import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.entities.TeamPlayedEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class PlayerDaoImpl extends GenericDaoImpl<PlayerEntity> implements PlayerDao {
    @PersistenceContext(unitName = "football")
    EntityManager em;

    public PlayerDaoImpl() {
        super(PlayerEntity.class);
    }



}
