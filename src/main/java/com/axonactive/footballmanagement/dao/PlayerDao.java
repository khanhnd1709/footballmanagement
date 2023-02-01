package com.axonactive.footballmanagement.dao;

import com.axonactive.footballmanagement.entities.TeamPlayedEntity;
import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.rest.request.PlayerRequest;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public interface PlayerDao extends GenericDao<PlayerEntity> {
    TeamPlayedEntity getCurrentTeamPlayedByPlayerId(Long id);

}