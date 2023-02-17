package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.entities.TeamPlayedEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.rest.request.TeamPlayedRequest;
import com.axonactive.footballmanagement.service.TeamPlayedService;
import com.axonactive.footballmanagement.service.dto.PlayerDto;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path(TeamPlayedResource.PATH)
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
public class TeamPlayedResource extends GenericResource<TeamPlayedEntity, PlayerDto> {
    public static final String PATH = TeamResource.PATH + "/{teamId}/" + PlayerResource.PATH;

    @Inject
    private TeamPlayedService teamPlayedService;


    @GET
    public Response findAllTeamPlayedByTeamId(@PathParam("teamId") Long teamId) {
        return Response.ok().entity(teamPlayedService.findAllTeamPlayedsByTeamId(teamId)).build();
    }

    @GET
    public Response findActivePlayersByTeamId(@PathParam("teamId") Long teamId) {
        try {
            return Response.ok().entity(teamPlayedService.findActiveTeamPlayedsByTeamId(teamId)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @POST
    public Response create(Long teamId, @Valid List<TeamPlayedRequest> teamPlayedRequestList) {
        try {
            return Response.status(Response.Status.CREATED).entity(teamPlayedService.create_fromRequest_toDto(teamId, teamPlayedRequestList)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }
}
