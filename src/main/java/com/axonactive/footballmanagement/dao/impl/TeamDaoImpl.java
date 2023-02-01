package com.axonactive.footballmanagement.dao.impl;

import com.axonactive.footballmanagement.dao.TeamDao;
import com.axonactive.footballmanagement.entities.TeamEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class TeamDaoImpl extends GenericDaoImpl<TeamEntity> implements TeamDao {

    protected TeamDaoImpl() {
        super(TeamEntity.class);
    }
}
