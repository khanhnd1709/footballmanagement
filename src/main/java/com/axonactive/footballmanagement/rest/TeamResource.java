package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.entities.TeamEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.rest.request.TeamRequest;
import com.axonactive.footballmanagement.service.PlayerService;
import com.axonactive.footballmanagement.service.TeamPlayedService;
import com.axonactive.footballmanagement.service.TeamService;
import com.axonactive.footballmanagement.service.dto.TeamDto;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path(TeamResource.PATH)
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource extends GenericResource<TeamEntity, TeamDto> {

    public static final String PATH = "teams";

    @Inject
    private TeamService teamService;

//    @GET
//    public Response findAllTeams() {
//        return Response.ok().entity(teamService.findAll_toDto()).build();
//    }
//
//    @GET
//    @Path("{id}")
//    public Response findTeamById(Long id) {
//        try {
//            return Response.ok().entity(teamService.findById_toDto(id)).build();
//        } catch (CustomException exception) {
//            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
//        }
//    }
//
    @POST
    public Response create(@Valid TeamRequest team) {
        try {
            return Response.status(Response.Status.CREATED).entity(teamService.create_toDto(team)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, @Valid TeamRequest team) {
        try {
            return Response.ok().entity(teamService.update_toDto(id, team)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }
//
//    @DELETE
//    @Path("{id}")
//    public Response deleteTeam(@PathParam("id") Long id) {
//        try {
//            teamService.delete(id);
//            return Response.status(Response.Status.NO_CONTENT).build();
//        }
//        catch (CustomException exception) {
//            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
//        }
//    }


}
