package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.PlayerDao;
import com.axonactive.footballmanagement.entities.PlayForClubEntity;
import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.service.dto.PlayerDto;
import com.axonactive.footballmanagement.service.mapper.PlayerMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PlayerService {

    @Inject
    private PlayerDao playerDao;

    @Inject
    private PlayerMapper playerMapper;

    public PlayerDto getPlayerById(Long id) {
        return playerMapper.toDto(playerDao.getPlayerById(id));
    }

    public List<PlayerDto> getAllPlayers() {
        return playerMapper.toDtos(playerDao.getAllPlayers());
    }

}
