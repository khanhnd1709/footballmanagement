package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.PlayerDao;
import com.axonactive.footballmanagement.dao.TeamDao;
import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.entities.TeamEntity;
import com.axonactive.footballmanagement.entities.TeamPlayedEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.rest.exception.errormessages.ErrorConstant;
import com.axonactive.footballmanagement.rest.request.PlayerRequest;
import com.axonactive.footballmanagement.service.dto.PlayerDto;
import com.axonactive.footballmanagement.service.mapper.PlayerMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class PlayerService extends GenericService<PlayerEntity> {

    @Inject
    private PlayerDao playerDao;

    @Inject
    private PlayerMapper playerMapper;

    @Inject
    private TeamService teamService;

    protected PlayerService() {
        super(PlayerEntity.class);
    }

    public PlayerDto getPlayerDtoById(Long id) {
        TeamPlayedEntity currentTeamPlayed = playerDao.getCurrentTeamPlayedByPlayerId(id);
        if (currentTeamPlayed != null) {
            return playerMapper.toDto(currentTeamPlayed);
        }
        return playerMapper.toDto(findById(id));
    }

    public List<PlayerDto> getAllPlayers() {
        List<PlayerEntity> players = playerDao.findAll();
        return players.stream()
                .map(player -> {
                    TeamPlayedEntity currentTeamPlayed = playerDao.getCurrentTeamPlayedByPlayerId(player.getId());
                    if (currentTeamPlayed != null) {
                        return playerMapper.toDto(currentTeamPlayed);
                    }
                    return playerMapper.toDto(player);
                })
                .collect(Collectors.toList());
    }

    public List<PlayerDto> getCurrentActivePlayersByTeamId(Long id) {
        TeamEntity team = teamService.findById(id);
        return playerMapper.toDtos(team.getAllPlayers().stream()
                .filter(TeamPlayedEntity::getIsActive)
                .collect(Collectors.toList()));
    }

    public PlayerDto createPlayer(PlayerEntity player) {
        if (player.getId() != null)
            throw new CustomException(ErrorConstant.MSG_ID_PROVIDED_IN_CREATE_METHOD, Response.Status.BAD_REQUEST);
        return playerMapper.toDto(playerDao.makePersistent(player));
    }

    public PlayerDto updatePlayer(Long id, PlayerEntity player) {
        if (!id.equals(player.getId()))
            throw new CustomException(ErrorConstant.MSG_IDPATHPARAM_CONFLICT_IDBODY, Response.Status.FORBIDDEN);
        findById(id);
        return playerMapper.toDto(playerDao.makePersistent(player));
    }

    public void deletePlayer(Long id) {
        playerDao.makeTransient(findById(id));
    }

    public void validateGeneralAddRequest(List<?> objects) {
        isRequestEmpty(objects);
    }



    public void validateAddPlayerRequest(List<PlayerRequest> playerRequests) {
        // Check active of 1 club do not larger than maxNumberEachClub of League

        // More...
    }
}
