package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.SeasonDao;
import com.axonactive.footballmanagement.dao.StadiumDao;
import com.axonactive.footballmanagement.entities.SeasonEntity;
import com.axonactive.footballmanagement.entities.TeamPlayedEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.rest.exception.errormessages.ErrorConstant;
import com.axonactive.footballmanagement.rest.request.SeasonRequest;
import com.axonactive.footballmanagement.rest.request.TeamPlayedRequest;
import com.axonactive.footballmanagement.rest.request.TeamRequest;
import com.axonactive.footballmanagement.service.dto.SeasonDto;
import com.axonactive.footballmanagement.service.dto.TeamDto;
import com.axonactive.footballmanagement.service.mapper.SeasonMapper;
import com.axonactive.footballmanagement.service.mapper.StadiumMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class SeasonService extends GenericService<SeasonEntity, SeasonDto> {
    @Inject
    private SeasonMapper seasonMapper;

    @Inject
    private LeagueService leagueService;

    public SeasonService() {
        super(SeasonEntity.class, SeasonDto.class);
    }


    public List<SeasonEntity> findAllSeasonByLeagueId(Long leagueId) {
        return sortByStartDate(leagueService.findById(leagueId).getSeasons(), false);
    }

    public Optional<SeasonEntity> findLastSeasonByLeagueId(Long leagueId) {
        return findAllSeasonByLeagueId(leagueId).stream()
                .findFirst();
    }

    public SeasonDto create_toDto(Long leagueId, SeasonRequest seasonRequest) {
        checkLeagueIdPathParamEqualLeagueIdBody(leagueId, seasonRequest);

        // Check endDate >= startDate
        checkEndDateNotIsBeforeStartDate(seasonRequest);

        // Check endDate >= startDate
        checkStartDateNotIsBeforeLastEndDate(seasonRequest);

        return seasonMapper.toDto(create(seasonMapper.toEntity(seasonRequest)));
    }

    public SeasonDto update_toDto(Long id, Long leagueId, SeasonRequest season) {
        return seasonMapper.toDto(update(id, seasonMapper.toEntity(season)));
    }

    private void checkLeagueIdPathParamEqualLeagueIdBody(Long leagueId, SeasonRequest seasonRequest) {
        if (!seasonRequest.getLeagueId().equals(leagueId))
            throw new CustomException(ErrorConstant.MSG_LEAGUE_IDPATHPARAM_CONFLICT_IDBODY, Response.Status.BAD_REQUEST);
    }

    private void checkEndDateNotIsBeforeStartDate(SeasonRequest seasonRequest) {
        if (seasonRequest.getEndDate() != null)
            if (seasonRequest.getEndDate().isBefore(seasonRequest.getStartDate()))
                throw new CustomException(ErrorConstant.MSG_ENDDATE_IS_BEFORE_STARTDATE, Response.Status.BAD_REQUEST);
    }

    private void checkStartDateNotIsBeforeLastEndDate(SeasonRequest seasonRequest) {
        Optional<SeasonEntity> lastSeasonByLeagueId = findLastSeasonByLeagueId(seasonRequest.getLeagueId());
        if (lastSeasonByLeagueId.isPresent())
            if (seasonRequest.getStartDate().isBefore(lastSeasonByLeagueId.get().getEndDate()))
                throw new CustomException(ErrorConstant.MSG_STARTDATE_IS_BEFORE_LAST_ENDDATE, Response.Status.BAD_REQUEST);
    }

    public List<SeasonEntity> sortByStartDate(List<SeasonEntity> seasonEntities, boolean ascending) {
        List<SeasonEntity> seasons = seasonEntities.stream()
                .sorted(Comparator.comparing(SeasonEntity::getStartDate))
                .collect(Collectors.toList());
        if (!ascending) Collections.reverse(seasons);
        return seasons;
    }

}