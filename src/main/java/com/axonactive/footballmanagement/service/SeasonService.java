package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.entities.SeasonEntity;

import javax.ejb.Stateless;

@Stateless
public class SeasonService extends GenericService<SeasonEntity> {
    public SeasonService() {
        super(SeasonEntity.class);
    }

}
