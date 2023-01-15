package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.service.MatchService;
import com.axonactive.footballmanagement.service.PlayerService;
import com.axonactive.footballmanagement.service.dto.MatchDto;
import com.axonactive.footballmanagement.service.dto.PlayerDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

@Stateless
@Path(MatchResource.PATH)
public class MatchResource {
    public static final String PATH = "matches";

    @Inject
    private MatchService matchService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMatchesByDate(@QueryParam("fromDate") String fromDate, @QueryParam("toDate") String toDate) {
        List<MatchDto> matches = matchService.getMatchesByDate(fromDate, toDate);
        return Response.ok().entity(matches).build();
    }
}
