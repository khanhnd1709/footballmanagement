package com.axonactive.footballmanagement.dao.impl;

import com.axonactive.footballmanagement.dao.StadiumDao;
import com.axonactive.footballmanagement.entities.StadiumEntity;

import javax.ejb.Stateless;

@Stateless
public class StadiumDaoImpl extends GenericDaoImpl<StadiumEntity> implements StadiumDao {
    public StadiumDaoImpl() {
        super(StadiumEntity.class);
    }
}
