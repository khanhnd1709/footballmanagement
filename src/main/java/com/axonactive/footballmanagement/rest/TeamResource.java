package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.entities.TeamEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.service.PlayerService;
import com.axonactive.footballmanagement.service.TeamService;
import com.axonactive.footballmanagement.service.dto.PlayerDto;
import com.axonactive.footballmanagement.service.dto.TeamDto;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path(TeamResource.PATH)
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {

    public static final String PATH = "teams";

    @Inject
    private PlayerService playerService;

    @Inject
    private TeamService teamService;

    @GET
    @Path("{id}")
    public Response findTeamById(Long id) {
        try {
            return Response.ok()
                    .entity(teamService.findTeamById(id))
                    .build();
        }
        catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus())
                    .entity(exception.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }

    @POST
    public Response createTeam(@Valid TeamEntity team) {
        try {
            return Response.status(Response.Status.CREATED)
                    .entity(teamService.createTeam(team))
                    .build();
        }
        catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus())
                    .entity(exception.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }

    @PUT
    @Path("{id}")
    public Response updateTeam(@PathParam("id") Long id, @Valid TeamEntity team) {
        try {
            return Response.ok()
                    .entity(teamService.updateTeam(id, team))
                    .build();
        }
        catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus())
                    .entity(exception.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteTeam(@PathParam("id") Long id) {
        try {
            teamService.deleteTeam(id);
            return Response.status(Response.Status.NO_CONTENT)
                    .build();
        }
        catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus())
                    .entity(exception.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }

    @GET
    @Path("{id}/" + PlayerResource.PATH)
    public Response findCurrentActivePlayersByTeamId(@PathParam("id") Long id) {
        try {
            return Response.ok()
                    .entity(playerService.findCurrentActivePlayersByTeamId(id))
                    .build();
        }
        catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus())
                    .entity(exception.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }

    @POST
    @Path("{teamId}/" + PlayerResource.PATH + "{playerId}")
    public Response createTeamPlayed(@PathParam("teamId") Long teamId,
                                                     @PathParam("playerId") Long playerId) {
        try {
            return Response.ok()
                    .entity(playerService.findCurrentActivePlayersByTeamId(teamId))
                    .build();
        }
        catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus())
                    .entity(exception.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }
}
