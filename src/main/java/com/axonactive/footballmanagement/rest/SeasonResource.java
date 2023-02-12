package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.entities.SeasonEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.rest.request.SeasonRequest;
import com.axonactive.footballmanagement.rest.request.TeamRequest;
import com.axonactive.footballmanagement.service.SeasonService;
import com.axonactive.footballmanagement.service.dto.SeasonDto;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(SeasonResource.PATH)
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
public class SeasonResource extends GenericResource<SeasonEntity, SeasonDto> {

    public static final String PATH = LeagueResource.PATH + "/{leagueId}/seasons";
    @Inject
    private SeasonService seasonService;

    @POST
    public Response create(@PathParam("leagueId") Long leagueId, @Valid SeasonRequest season) {
        try {
            return Response.status(Response.Status.CREATED).entity(seasonService.create_toDto(leagueId, season)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id,  @PathParam("leagueId") Long leagueId, @Valid SeasonRequest season) {
        try {
            return Response.ok().entity(seasonService.update_toDto(id, leagueId, season)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }
}
