package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.rest.request.PlayerRequest;
import com.axonactive.footballmanagement.service.PlayerService;
import com.axonactive.footballmanagement.service.dto.PlayerDto;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path(PlayerResource.PATH)
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PlayerResource {
    public static final String PATH = "players";

    @Inject
    private PlayerService playerService;

    @GET
    public Response getAllPlayers() {
        List<PlayerDto> players = playerService.getAllPlayers();
        return Response.ok().entity(players).build();
    }

    @GET
    @Path("{id}")
    public Response getPlayerById(@PathParam("id") Long id) {
        try {
            PlayerDto player = playerService.getPlayerDtoById(id);
            return Response.ok().entity(player).build();
        }
        catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus())
                    .entity(exception.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }

    @POST
    public Response createPlayer(@Valid PlayerEntity player) {
        try {
            return Response.status(Response.Status.CREATED)
                    .entity(playerService.createPlayer(player)).build();
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
    public Response updatePlayer(@PathParam("id") Long id, @Valid PlayerEntity player) {
        try {
            return Response.ok()
                    .entity(playerService.updatePlayer(id, player)).build();
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
    public Response deletePlayer(@PathParam("id") Long id) {
        try {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus())
                    .entity(exception.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }

//    @POST
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response addPlayers(@Valid List<PlayerRequest> playerRequests) {
//        try {
//            return Response.ok().entity(playerService.addPlayers(playerRequests)).build();
//        } catch (Exception e) {
//            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
//        }
//    }
}
