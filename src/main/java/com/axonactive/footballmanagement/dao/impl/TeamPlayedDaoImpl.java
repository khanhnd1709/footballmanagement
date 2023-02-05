package com.axonactive.footballmanagement.dao.impl;

import com.axonactive.footballmanagement.dao.TeamPlayedDao;
import com.axonactive.footballmanagement.entities.TeamPlayedEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class TeamPlayedDaoImpl extends GenericDaoImpl implements TeamPlayedDao {

    public TeamPlayedDaoImpl() {
        super(TeamPlayedEntity.class);
    }
}
