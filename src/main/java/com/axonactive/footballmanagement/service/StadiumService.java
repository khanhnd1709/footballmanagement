package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.StadiumDao;
import com.axonactive.footballmanagement.dao.TeamDao;
import com.axonactive.footballmanagement.entities.StadiumEntity;
import com.axonactive.footballmanagement.rest.request.TeamRequest;
import com.axonactive.footballmanagement.service.dto.StadiumDto;
import com.axonactive.footballmanagement.service.dto.TeamDto;
import com.axonactive.footballmanagement.service.mapper.StadiumMapper;
import com.axonactive.footballmanagement.service.mapper.TeamMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class StadiumService extends GenericService<StadiumEntity, StadiumDto> {

    public StadiumService() {
        super(StadiumEntity.class, StadiumDto.class);
    }

}
