package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.entities.TeamEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.service.PlayerService;
import com.axonactive.footballmanagement.service.TeamPlayedService;
import com.axonactive.footballmanagement.service.TeamService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path(TeamResource.PATH)
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {

    public static final String PATH = "teams";

    @Inject
    private TeamPlayedService teamPlayedService;

    @Inject
    private TeamService teamService;

    @GET
    public Response findAllTeams() {
        return Response.ok().entity(teamService.findAll_ToTeamDto()).build();
    }

    @GET
    @Path("{id}")
    public Response findTeamById(Long id) {
        try {
            return Response.ok().entity(teamService.findById_ToTeamDto(id)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @POST
    public Response createTeam(@Valid TeamEntity team) {
        try {
            return Response.status(Response.Status.CREATED).entity(teamService.createTeam(team)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response updateTeam(@PathParam("id") Long id, @Valid TeamEntity team) {
        try {
            return Response.ok().entity(teamService.updateTeam(id, team)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteTeam(@PathParam("id") Long id) {
        try {
            teamService.deleteTeam(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }


}
