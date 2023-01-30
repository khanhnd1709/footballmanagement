package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.service.PlayerService;
import com.axonactive.footballmanagement.service.dto.PlayerDto;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path(TeamResource.PATH)
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {

    public static final String PATH = "teams";

    @Inject
    private PlayerService playerService;

    @GET
    @Path("{id}/" + PlayerResource.PATH)
    public Response getCurrentActivePlayersByTeamId(@PathParam("id") Long id) {
        List<PlayerDto> players = playerService.getCurrentActivePlayersByTeamId(id);
        return Response.ok().entity(players).build();
    }
}
