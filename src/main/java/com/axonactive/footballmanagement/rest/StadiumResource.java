package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.entities.StadiumEntity;
import com.axonactive.footballmanagement.service.dto.StadiumDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(StadiumResource.PATH)
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
public class StadiumResource extends GenericResource<StadiumEntity, StadiumDto> {
    public static final String PATH = "stadiums";

}
