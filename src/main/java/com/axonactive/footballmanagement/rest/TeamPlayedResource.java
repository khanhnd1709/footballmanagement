package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.rest.request.TeamPlayedRequest;
import com.axonactive.footballmanagement.service.TeamPlayedService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(TeamPlayedResource.PATH)
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
public class TeamPlayedResource {
    public static final String PATH = "teams/{teamId}/players";

    @Inject
    private TeamPlayedService teamPlayedService;


    @GET
    public Response findAllTeamPlayedByTeamId(@PathParam("id") Long teamId) {
        return Response.ok().entity(teamPlayedService.findAllTeamPlayedsByTeamId(teamId)).build();
    }

    @GET
    public Response findActivePlayersByTeamId(@PathParam("id") Long id) {
        try {
            return Response.ok().entity(teamPlayedService.findActiveTeamPlayedsByTeamId(id)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @POST
    @Path("{playerId}")
    public Response createTeamPlayed(@PathParam("teamId") Long teamId,
                                     @PathParam("playerId") Long playerId,
                                     @Valid TeamPlayedRequest teamPlayedRequest) {
        try {
            return Response.status(Response.Status.CREATED).entity(teamPlayedService.createTeamPlayed(teamId, playerId, teamPlayedRequest)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }
}
