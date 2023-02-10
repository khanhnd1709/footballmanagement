package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.entities.SeasonEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.rest.request.SeasonRequest;
import com.axonactive.footballmanagement.rest.request.TeamRequest;
import com.axonactive.footballmanagement.service.SeasonService;
import com.axonactive.footballmanagement.service.dto.SeasonDto;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class SeasonResource extends GenericResource<SeasonEntity, SeasonDto> {

    @Inject
    private SeasonService seasonService;

    @POST
    public Response createTeam(@Valid SeasonRequest season) {
        try {
            return Response.status(Response.Status.CREATED).entity(seasonService.create_toDto(season)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response updateTeam(@PathParam("id") Long id, @Valid SeasonRequest season) {
        try {
            return Response.ok().entity(seasonService.update_toDto(id, season)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }
}
