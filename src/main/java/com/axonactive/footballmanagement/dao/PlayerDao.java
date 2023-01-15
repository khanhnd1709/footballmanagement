package com.axonactive.footballmanagement.dao;

import com.axonactive.footballmanagement.entities.PlayForClubEntity;
import com.axonactive.footballmanagement.entities.PlayerEntity;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public interface PlayerDao {
    PlayForClubEntity getPlayerById(Long id);
    List<PlayForClubEntity> getAllPlayers();
}