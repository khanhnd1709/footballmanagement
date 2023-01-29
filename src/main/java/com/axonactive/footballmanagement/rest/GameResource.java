package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.service.GameService;
import com.axonactive.footballmanagement.service.dto.GameDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path(GameResource.PATH)
public class GameResource {
    public static final String PATH = "matches";

    @Inject
    private GameService gameService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMatchesByDate(@QueryParam("fromDate") String fromDate, @QueryParam("toDate") String toDate) {
        List<GameDto> matches = gameService.getMatchesByDate(fromDate, toDate);
        return Response.ok().entity(matches).build();
    }
}
