package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.service.PlayerService;
import com.axonactive.footballmanagement.service.dto.PlayerDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path(PlayerResource.PATH)
public class PlayerResource {
    public static final String PATH = "players";

    @Inject
    private PlayerService playerService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{playerId}")
    public Response getPlayerById(@PathParam("playerId") Long playerId) {
        PlayerDto player = playerService.getPlayerById(playerId);
        return Response.ok().entity(player).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllPlayers() {
        List<PlayerDto> players = playerService.getAllPlayers();
        return Response.ok().entity(players).build();
    }
}
