package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.service.GameService;
import com.axonactive.footballmanagement.service.dto.GameDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Path(GameResource.PATH)
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {
    public static final String PATH = "games";

    @Inject
    private GameService gameService;

    @GET
    public Response getMatchesByDate(@QueryParam("fromDate") String fromDate, @QueryParam("toDate") String toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fromLocalDate = LocalDate.parse(fromDate, formatter);
        LocalDate toLocalDate = LocalDate.parse(toDate, formatter);
        List<GameDto> games = gameService.findGamesByDate(fromLocalDate, toLocalDate);
        return Response.ok().entity(games).build();
    }
}
