package com.axonactive.footballmanagement.dao.impl;

import com.axonactive.footballmanagement.dao.PlayerDao;
import com.axonactive.footballmanagement.dao.SeasonDao;
import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.entities.SeasonEntity;

import javax.ejb.Stateless;

@Stateless
public class SeasonDaoImpl extends GenericDaoImpl<SeasonEntity> implements SeasonDao {
    public SeasonDaoImpl() {
        super(SeasonEntity.class);
    }
}
