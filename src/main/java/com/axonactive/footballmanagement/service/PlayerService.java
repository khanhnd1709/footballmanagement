package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.PlayerDao;
import com.axonactive.footballmanagement.dao.TeamDao;
import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.entities.TeamEntity;
import com.axonactive.footballmanagement.entities.TeamPlayedEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.rest.exception.errormessages.ErrorConstant;
import com.axonactive.footballmanagement.service.dto.PlayerDto;
import com.axonactive.footballmanagement.service.mapper.PlayerMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class PlayerService extends GenericService<PlayerEntity, PlayerDto> {

//    @Inject
//    private TeamService teamService;
//
//    @Inject
//    private TeamPlayedService teamPlayedService;
//
//    @Inject
//    private PlayerDao playerDao;
//
//    @Inject
//    private PlayerMapper playerMapper;

    public PlayerService() {
        super(PlayerEntity.class, PlayerDto.class);
    }

//    public PlayerDto findById_ToPlayerDto(Long id) {
//        PlayerDto playerDto = teamPlayedService.findCurrentTeamPlayedByPlayerId_ToPlayerDto(id);
//        if (playerDto == null) playerDto = playerMapper.toDto(findById(id));
//        return playerDto;
//    }

//    public List<PlayerDto> findAll_ToPlayerDto() {
//        return findAll().stream()
//                .map(player -> findById_ToPlayerDto(player.getId()))
//                .collect(Collectors.toList());
//    }
//
//    public PlayerDto createPlayer(PlayerEntity player) {
//        return playerMapper.toDto(create(player));
//    }
//
//    public PlayerDto updatePlayer(Long id, PlayerEntity player) {
//        return playerMapper.toDto(update(id, player));
//    }
//
//    public void deletePlayer(Long id) {
//        delete(id);
//    }

    public void validateGeneralAddRequest(List<?> objects) {
        checkRequestEmpty(objects);
    }
}
