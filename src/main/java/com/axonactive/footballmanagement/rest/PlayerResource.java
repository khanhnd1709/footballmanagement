package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.entities.PlayerEntity;
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
    @Path("{playerId}")
    public Response getPlayerById(@PathParam("playerId") Long playerId) {
        PlayerDto player = playerService.getPlayerById(playerId);
        return Response.ok().entity(player).build();
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
