package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.PlayerDao;
import com.axonactive.footballmanagement.entities.PlayForClubEntity;
import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.rest.exception.AddingException;
import com.axonactive.footballmanagement.rest.exception.errormessages.ErrorConstant;
import com.axonactive.footballmanagement.rest.request.PlayerRequest;
import com.axonactive.footballmanagement.service.dto.PlayerDto;
import com.axonactive.footballmanagement.service.mapper.PlayerMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<PlayerDto> getAllPlayersByClubId(Long clubId) {
        return playerMapper.toDtos(playerDao.getAllPlayersByClubId(clubId));
    }
    @Transactional(rollbackOn = Exception.class)
    public List<PlayerDto> addPlayers(List<PlayerRequest> playerRequests) {
        List<PlayerDto> playerToResponse = new ArrayList<>();
        validateGeneralAddRequest(playerRequests);
        playerRequests.forEach(playerRequest ->
                playerToResponse.add(playerMapper.toDto(playerDao.addPlayer(playerRequest))));
        return playerToResponse;
    }

    public void validateGeneralAddRequest(List<?> objects) {
        isRequestEmpty(objects);
    }

    private void isRequestEmpty(List<?> objects) {
        if (objects.isEmpty()) {
            throw new AddingException(ErrorConstant.MSG_REQUEST_EMPTY, Response.Status.BAD_REQUEST);
        }
    }

    public void validateAddPlayerRequest(List<PlayerRequest> playerRequests) {
        // Check active of 1 club do not larger than maxNumberEachClub of League

        // More...
    }
}
