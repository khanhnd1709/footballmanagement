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
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
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

    public List<SeasonDto> findAll_toDto(Long leagueId) {
        return seasonMapper.toDtos(findAllSeasonByLeagueId(leagueId));
    }

    @Transactional(rollbackOn = Exception.class)
    public List<SeasonDto> create_toDto(Long leagueId, List<SeasonRequest> seasonRequestList) {
        seasonRequestList.forEach(seasonRequest -> {
            checkLeagueIdPathParamEqualLeagueIdBody(leagueId, seasonRequest);
            checkEndDateNotIsBeforeStartDate(seasonRequest);
            checkValidDateRange(seasonRequest);
        });
        return seasonMapper.toDtos(create(seasonMapper.toEntities(seasonRequestList)));
    }

    public SeasonDto update_toDto(Long id, Long leagueId, SeasonRequest seasonRequest) {

        checkLeagueIdPathParamEqualLeagueIdBody(leagueId, seasonRequest);

        checkEndDateNotIsBeforeStartDate(seasonRequest);

        checkValidDateRange(seasonRequest);

        return seasonMapper.toDto(update(id, seasonMapper.toEntity(seasonRequest)));
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

    private void checkValidDateRange(SeasonRequest seasonRequest) {
        LocalDate startDate = seasonRequest.getStartDate();
        LocalDate endDate = seasonRequest.getEndDate();
        List<SeasonEntity> seasonEntities = findAllSeasonByLeagueId(seasonRequest.getLeagueId());
        if (endDate == null) {
            Optional<SeasonEntity> lastSeason = seasonEntities.stream().findFirst();
            if (lastSeason.isPresent()) {
                if (lastSeason.get().getEndDate() == null)
                    throw new CustomException(ErrorConstant.MSG_LEAGUE_NOT_END_YET, Response.Status.BAD_REQUEST);
                else if (lastSeason.get().getEndDate().isAfter(startDate))
                    throw new CustomException(ErrorConstant.MSG_STARTDATE_IS_BEFORE_LAST_ENDDATE, Response.Status.BAD_REQUEST);
            }
        }
        else {
            seasonEntities.forEach(teamPlayed -> {
                if ((teamPlayed.getStartDate().isBefore(startDate) && teamPlayed.getEndDate().isAfter(startDate))
                        || (teamPlayed.getStartDate().isBefore(endDate) && teamPlayed.getEndDate().isAfter(endDate)))
                    throw new CustomException(ErrorConstant.MSG_EXIST_OBJECT_ON_DATE, Response.Status.BAD_REQUEST);

            });
        }
    }

    public List<SeasonEntity> sortByStartDate(List<SeasonEntity> seasonEntities, boolean ascending) {
        List<SeasonEntity> seasons = seasonEntities.stream()
                .sorted(Comparator.comparing(SeasonEntity::getStartDate))
                .collect(Collectors.toList());
        if (!ascending) Collections.reverse(seasons);
        return seasons;
    }

}