package com.axonactive.footballmanagement.dao.impl;

import com.axonactive.footballmanagement.dao.LeagueDao;
import com.axonactive.footballmanagement.entities.LeagueEntity;
import com.axonactive.footballmanagement.entities.SeasonEntity;

import javax.ejb.Stateless;

@Stateless
public class LeagueDaoImpl extends GenericDaoImpl<LeagueEntity> implements LeagueDao {

    public LeagueDaoImpl() {
        super(LeagueEntity.class);
    }
}
