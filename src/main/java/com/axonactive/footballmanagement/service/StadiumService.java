package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.entities.StadiumEntity;

import javax.ejb.Stateless;

@Stateless
public class StadiumService extends GenericService<StadiumEntity> {

    public StadiumService() {
        super(StadiumEntity.class);
    }
}
