package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.entities.LeagueEntity;
import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.service.LeagueService;
import com.axonactive.footballmanagement.service.PlayerService;
import com.axonactive.footballmanagement.service.TeamPlayedService;
import com.axonactive.footballmanagement.service.dto.PlayerDto;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path(PlayerResource.PATH)
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PlayerResource extends GenericResource<PlayerEntity, PlayerDto> {
    public static final String PATH = "players";

    @Inject
    private PlayerService playerService;

    @POST
    public Response create(@Valid List<PlayerEntity> playerEntities) {
        try {
            return Response.status(Response.Status.CREATED).entity(playerService.create_toDto(playerEntities)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, @Valid PlayerEntity playerEntity) {
        try {
            return Response.ok().entity(playerService.update_toDto(id, playerEntity)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }
//    @Inject
//    private TeamPlayedService teamPlayedService;
//
//    @Inject
//    private PlayerService playerService;
//
//    @GET
//    public Response findAllPlayers() {
//        return Response.ok().entity(playerService.findAll_ToPlayerDto()).build();
//    }
//
//    @GET
//    @Path("{id}")
//    public Response findPlayerById(@PathParam("id") Long id) {
//        try {
//            return Response.ok().entity(playerService.findById_ToPlayerDto(id)).build();
//        } catch (CustomException exception) {
//            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
//        }
//    }
//
//    @POST
//    public Response createPlayer(@Valid PlayerEntity player) {
//        try {
//            return Response.status(Response.Status.CREATED).entity(playerService.createPlayer(player)).build();
//        } catch (CustomException exception) {
//            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
//        }
//    }
//
//    @PUT
//    @Path("{id}")
//    public Response updatePlayer(@PathParam("id") Long id, @Valid PlayerEntity player) {
//        try {
//            return Response.ok().entity(playerService.updatePlayer(id, player)).build();
//        } catch (CustomException exception) {
//            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
//        }
//    }
//
//    @DELETE
//    @Path("{id}")
//    public Response deletePlayer(@PathParam("id") Long id) {
//        try {
//            playerService.deletePlayer(id);
//            return Response.status(Response.Status.NO_CONTENT).build();
//        } catch (CustomException exception) {
//            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
//        }
//    }

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
