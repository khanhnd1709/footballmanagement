package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.TeamDao;
import com.axonactive.footballmanagement.entities.TeamEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TeamService extends GenericService<TeamEntity> {

    protected TeamService(Class<TeamEntity> entityClass) {
        super(entityClass);
    }
}
