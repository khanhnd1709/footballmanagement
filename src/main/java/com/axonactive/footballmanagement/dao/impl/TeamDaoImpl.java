package com.axonactive.footballmanagement.dao.impl;

import com.axonactive.footballmanagement.dao.TeamDao;
import com.axonactive.footballmanagement.entities.TeamEntity;

import javax.ejb.Stateless;

@Stateless
public class TeamDaoImpl extends GenericDaoImpl<TeamEntity> implements TeamDao {

    public TeamDaoImpl() {
        super(TeamEntity.class);
    }
}
