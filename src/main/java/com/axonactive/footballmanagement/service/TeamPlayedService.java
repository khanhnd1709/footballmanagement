package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.TeamPlayedDao;
import com.axonactive.footballmanagement.entities.TeamPlayedEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.rest.exception.errormessages.ErrorConstant;
import com.axonactive.footballmanagement.rest.request.TeamPlayedRequest;
import com.axonactive.footballmanagement.service.dto.PlayerDto;
import com.axonactive.footballmanagement.service.mapper.TeamPlayedMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class TeamPlayedService extends GenericService<TeamPlayedEntity, PlayerDto> {

    @Inject
    private PlayerService playerService;

    @Inject
    private TeamService teamService;

    @Inject
    private TeamPlayedDao teamPlayedDao;

    @Inject
    private TeamPlayedMapper teamPlayedMapper;

    public TeamPlayedService() {
        super(TeamPlayedEntity.class, PlayerDto.class);
    }

    public List<TeamPlayedEntity> findAllTeamPlayedByPlayerId(Long playerId) {
        return sortByAttendDate(playerService.findById(playerId).getTeams(), false);
    }

    public Optional<TeamPlayedEntity> findCurrentTeamPlayedByPlayerId(Long playerId) {
        return findAllTeamPlayedByPlayerId(playerId).stream()
                .filter(this::isCurrentTeamPlayed)
                .findFirst();
    }

    public PlayerDto findCurrentTeamPlayedByPlayerId_toDto(Long playerId) {
        return teamPlayedMapper.toDto(findCurrentTeamPlayedByPlayerId(playerId)
                .orElse(null));
    }

    public List<TeamPlayedEntity> findAllTeamPlayedsByTeamId(Long teamId) {
        return sortByAttendDate(teamService.findById(teamId).getPlayers(), false);
    }

    public List<PlayerDto> findCurrentTeamPlayedsByTeamId(Long teamId) {
        return teamPlayedMapper.toDtos(findAllTeamPlayedsByTeamId(teamId).stream()
                .filter(this::isCurrentTeamPlayed)
                .collect(Collectors.toList()));
    }

    public List<PlayerDto> findActiveTeamPlayedsByTeamId(Long teamId) {
        return teamPlayedMapper.toDtos(findAllTeamPlayedsByTeamId(teamId).stream()
                .filter(TeamPlayedEntity::getIsActive)
                .collect(Collectors.toList()));
    }

    @Transactional(rollbackOn = Exception.class)
    public List<PlayerDto> create_fromRequest_toDto(Long teamId, List<TeamPlayedRequest> teamPlayedRequestList) {
        return create_toDto(teamPlayedRequestList.stream()
                .map(teamPlayedRequest -> {
                    checkTeamIdPathParamEqualTeamIdBody(teamId, teamPlayedRequest);
                    checkLeaveDateIsAfterAttendDate(teamPlayedRequest);
                    checkIsCurrentRequest(teamPlayedRequest);
                    checkValidDateRange(teamPlayedRequest);
                    checkMaxActivePLayersByTeamIdBasedOnSeasonParticipated(teamId, teamPlayedRequest);

                    TeamPlayedEntity teamPlayedEntity = teamPlayedMapper.toEntity(teamPlayedRequest);
                    teamPlayedEntity.setPlayer(playerService.findById(teamPlayedRequest.getPlayerId()));
                    teamPlayedEntity.setTeam(teamService.findById(teamId));
                    return teamPlayedEntity;
                })
                .collect(Collectors.toList()));
    }

    public PlayerDto update_fromRequest_toDto(Long teamPlayedId, Long teamId, TeamPlayedRequest teamPlayedRequest) {
        checkTeamIdPathParamEqualTeamIdBody(teamId, teamPlayedRequest);
        checkLeaveDateIsAfterAttendDate(teamPlayedRequest);
        checkIsCurrentRequest(teamPlayedRequest);
        checkValidDateRange(teamPlayedRequest);
        checkMaxActivePLayersByTeamIdBasedOnSeasonParticipated(teamId, teamPlayedRequest);

        TeamPlayedEntity teamPlayedEntity = teamPlayedMapper.toEntity(teamPlayedRequest);
        teamPlayedEntity.setPlayer(playerService.findById(teamPlayedRequest.getPlayerId()));
        teamPlayedEntity.setTeam(teamService.findById(teamId));
        return update_toDto(teamPlayedId, teamPlayedEntity);
    }



    public List<TeamPlayedEntity> sortByAttendDate(List<TeamPlayedEntity> teamPlayedEntities, boolean ascending) {
        List<TeamPlayedEntity> teamPlayeds = teamPlayedEntities.stream()
                .sorted(Comparator.comparing(TeamPlayedEntity::getAttendDate))
                .collect(Collectors.toList());
        if (!ascending) Collections.reverse(teamPlayeds);
        return teamPlayeds;
    }

//    private void checkTeamPlayedIdPathParamEqualTeamPlayedIdBody(Long teamPlayedId, TeamPlayedRequest teamPlayedRequest) {
//        if (!teamPlayedRequest.getId().equals(teamPlayedId))
//            throw new CustomException(ErrorConstant.MSG_PLAYER_IDPATHPARAM_CONFLICT_IDBODY, Response.Status.BAD_REQUEST);
//    }
//
//    private void checkPlayerIdPathParamEqualPlayerIdBody(Long playerId, TeamPlayedRequest teamPlayedRequest) {
//        if (!teamPlayedRequest.getPlayerId().equals(playerId))
//            throw new CustomException(ErrorConstant.MSG_PLAYER_IDPATHPARAM_CONFLICT_IDBODY, Response.Status.BAD_REQUEST);
//    }

    private void checkTeamIdPathParamEqualTeamIdBody(Long teamId, TeamPlayedRequest teamPlayedRequest) {
        if (!teamPlayedRequest.getTeamId().equals(teamId))
            throw new CustomException(ErrorConstant.MSG_TEAM_IDPATHPARAM_CONFLICT_IDBODY, Response.Status.BAD_REQUEST);
    }

    private void checkValidDateRange(TeamPlayedRequest teamPlayedRequest) {
        LocalDate attendDate = teamPlayedRequest.getAttendDate();
        LocalDate leaveDate = teamPlayedRequest.getLeaveDate();
        List<TeamPlayedEntity> teamPlayeds = findAllTeamPlayedByPlayerId(teamPlayedRequest.getPlayerId());
        if (teamPlayedRequest.getIsCurrent()) {
            Optional<TeamPlayedEntity> lastTeamPLayed = teamPlayeds.stream().findFirst();
            if (lastTeamPLayed.isPresent()) {
                if (lastTeamPLayed.get().getIsCurrent())
                    throw new CustomException(ErrorConstant.MSG_EXIST_CURRENT_PLAYER, Response.Status.BAD_REQUEST);
                if (!lastTeamPLayed.get().getLeaveDate().isBefore(attendDate))
                    throw new CustomException(ErrorConstant.MSG_LAST_LEAVEDATE_IS_BEFORE_ATTENDDATE, Response.Status.BAD_REQUEST);
            }
        }
        else {
            teamPlayeds.forEach(teamPlayed -> {
                if ((!teamPlayed.getAttendDate().isAfter(attendDate) && !teamPlayed.getLeaveDate().isBefore(attendDate))
                        || (!teamPlayed.getAttendDate().isAfter(leaveDate) && !teamPlayed.getLeaveDate().isBefore(leaveDate)))
                    throw new CustomException(ErrorConstant.MSG_EXIST_OBJECT_ON_DATE, Response.Status.BAD_REQUEST);
            });
        }
    }

    private void checkIsCurrentRequest(TeamPlayedRequest teamPlayedRequest) {
        if (teamPlayedRequest.getIsCurrent()) {
            if (teamPlayedRequest.getLeaveDate() != null)
                throw new CustomException(ErrorConstant.MSG_LEAVEDATE_NULL, Response.Status.BAD_REQUEST);
        }
        else {
            if (teamPlayedRequest.getLeaveDate() == null)
                throw new CustomException(ErrorConstant.MSG_LEAVEDATE_NOT_NULL, Response.Status.BAD_REQUEST);
            if (teamPlayedRequest.getIsActive())
                throw new CustomException(ErrorConstant.MSG_WRONG_ACTIVE_PLAYER, Response.Status.BAD_REQUEST);
        }
    }

    private void checkLeaveDateIsAfterAttendDate(TeamPlayedRequest teamPlayedRequest) {
        if (teamPlayedRequest.getLeaveDate() != null)
            if (!teamPlayedRequest.getLeaveDate().isAfter(teamPlayedRequest.getAttendDate()))
                throw new CustomException(ErrorConstant.MSG_LEAVEDATE_IS_NOT_AFTER_ATTENDDATE, Response.Status.BAD_REQUEST);
    }

    private void checkMaxActivePLayersByTeamIdBasedOnSeasonParticipated(Long teamId, TeamPlayedRequest teamPlayedRequest) {
        if (teamPlayedRequest.getIsActive() && findActiveTeamPlayedsByTeamId(teamId).size() >= 5)
            throw new CustomException(ErrorConstant.MSG_MAX_ACTIVE_PLAYERS, Response.Status.FORBIDDEN);
    }

    public boolean isCurrentTeamPlayed(TeamPlayedEntity teamPlayedEntity) {
        LocalDate today = LocalDate.now();
        if (teamPlayedEntity.getAttendDate().isAfter(today))
            return false;
        if (teamPlayedEntity.getLeaveDate() != null)
            return !teamPlayedEntity.getLeaveDate().isBefore(today);
        return true;
    }
}