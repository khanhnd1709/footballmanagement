package com.axonactive.footballmanagement.dao.impl;

import com.axonactive.footballmanagement.dao.TeamDao;
import com.axonactive.footballmanagement.entities.TeamEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class TeamDaoImpl implements TeamDao {

    @PersistenceContext(unitName = "football")
    EntityManager em;

    @Override
    public TeamEntity getTeamById(Long id) {
        try {
            return em.find(TeamEntity.class, id);
        }
        catch (NoResultException noResultException) {
            return null;
        }
    }
}
