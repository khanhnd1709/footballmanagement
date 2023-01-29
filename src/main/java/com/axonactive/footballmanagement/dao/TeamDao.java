package com.axonactive.footballmanagement.dao;

import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.entities.TeamEntity;

import javax.ejb.Stateless;

@Stateless
public interface TeamDao {
    TeamEntity getTeamById(Long id);
}
