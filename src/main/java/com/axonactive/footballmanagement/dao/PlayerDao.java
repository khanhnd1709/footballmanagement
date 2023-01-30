package com.axonactive.footballmanagement.dao;

import com.axonactive.footballmanagement.entities.TeamPlayedEntity;
import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.rest.request.PlayerRequest;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public interface PlayerDao {
    PlayerEntity getPlayerById(Long id);
    List<PlayerEntity> getAllPlayers();
    TeamPlayedEntity getCurrentTeamPlayedByPlayerId(Long id);

    PlayerEntity createPlayer(PlayerEntity player);
}