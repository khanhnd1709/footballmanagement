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
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class TeamPlayedService extends GenericService<TeamPlayedEntity> {

    @Inject
    private PlayerService playerService;

    @Inject
    private TeamService teamService;

    @Inject
    private TeamPlayedDao teamPlayedDao;

    @Inject
    private TeamPlayedMapper teamPlayedMapper;

    public TeamPlayedService() {
        super(TeamPlayedEntity.class);
    }

    public List<TeamPlayedEntity> findAllTeamPlayedByPlayerId(Long playerId) {
        return sortByAttendDate(playerService.findById(playerId).getTeams(), false);
    }

    public Optional<TeamPlayedEntity> findCurrentTeamPlayedByPlayerId(Long playerId) {
        return findAllTeamPlayedByPlayerId(playerId).stream()
                .filter(this::isCurrentTeamPlayed)
                .findFirst();
    }

    public Optional<TeamPlayedEntity> findLastTeamPlayedBeforeFreeByPlayerId(Long playerId) {
        return findAllTeamPlayedByPlayerId(playerId).stream()
                .findFirst();
    }

    public PlayerDto findCurrentTeamPlayedByPlayerId_ToPlayerDto(Long playerId) {
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

    public PlayerDto createTeamPlayed(Long teamId, Long playerId, TeamPlayedRequest teamPlayedRequest) {
        checkTeamIdPathParamEqualTeamIdBody(teamId, teamPlayedRequest);
        checkPlayerIdPathParamEqualPlayerIdBody(playerId, teamPlayedRequest);

        // CheckFreeTeamPlayed
        checkFreeTeamPlayed(playerId);

        // Find last leave date < attendDate
        checkAttendDateNotIsBeforeLastAttendDate(teamPlayedRequest);

        // Check leaveDate >= attendDate
        checkLeaveDateNotIsBeforeAttendDate(teamPlayedRequest);

        // If isActive --> check if teamId join which league --> then find maxPLayerEachTeam of League
        checkMaxActivePLayersByTeamIdBasedOnSeasonParticipated(teamId);

        TeamPlayedEntity teamPlayed = teamPlayedMapper.toEntity(teamPlayedRequest);
        teamPlayed.setPlayer(playerService.findById(playerId));
        teamPlayed.setTeam(teamService.findById(teamId));
        return teamPlayedMapper.toDto(create(teamPlayed));
    }

    public List<TeamPlayedEntity> sortByAttendDate(List<TeamPlayedEntity> teamPlayedEntities, boolean ascending) {
        List<TeamPlayedEntity> teamPlayeds = teamPlayedEntities.stream()
                .sorted(Comparator.comparing(TeamPlayedEntity::getAttendDate))
                .collect(Collectors.toList());
        if (!ascending) Collections.reverse(teamPlayeds);
        return teamPlayeds;
    }

    private void checkPlayerIdPathParamEqualPlayerIdBody(Long playerId, TeamPlayedRequest teamPlayedRequest) {
        if (!teamPlayedRequest.getPlayerId().equals(playerId))
            throw new CustomException(ErrorConstant.MSG_PLAYER_IDPATHPARAM_CONFLICT_IDBODY, Response.Status.BAD_REQUEST);
    }

    private void checkTeamIdPathParamEqualTeamIdBody(Long teamId, TeamPlayedRequest teamPlayedRequest) {
        if (!teamPlayedRequest.getTeamId().equals(teamId))
            throw new CustomException(ErrorConstant.MSG_TEAM_IDPATHPARAM_CONFLICT_IDBODY, Response.Status.BAD_REQUEST);
    }

    private void checkFreeTeamPlayed(Long playerId) {
        if (findCurrentTeamPlayedByPlayerId(playerId).isPresent())
            throw new CustomException(ErrorConstant.MSG_EXIST_CURRENT_PLAYER, Response.Status.BAD_REQUEST);
    }

    private void checkAttendDateNotIsBeforeLastAttendDate(TeamPlayedRequest teamPlayedRequest) {
        Optional<TeamPlayedEntity> lastTeamPlayedBeforeFree = findLastTeamPlayedBeforeFreeByPlayerId(teamPlayedRequest.getPlayerId());
        if (lastTeamPlayedBeforeFree.isPresent())
            if (teamPlayedRequest.getAttendDate().isBefore(lastTeamPlayedBeforeFree.get().getLeaveDate()))
                throw new CustomException(ErrorConstant.MSG_ATTENDDATE_IS_BEFORE_LAST_LEAVEDATE, Response.Status.BAD_REQUEST);
    }

    private void checkLeaveDateNotIsBeforeAttendDate(TeamPlayedRequest teamPlayedRequest) {
        if (teamPlayedRequest.getLeaveDate() != null)
            if (teamPlayedRequest.getLeaveDate().isBefore(teamPlayedRequest.getAttendDate()))
                throw new CustomException(ErrorConstant.MSG_LEAVEDATE_IS_BEFORE_ATTENDDATE, Response.Status.BAD_REQUEST);
    }

    private void checkMaxActivePLayersByTeamIdBasedOnSeasonParticipated(Long teamId) {
        if (findActiveTeamPlayedsByTeamId(teamId).size() >= 30)
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