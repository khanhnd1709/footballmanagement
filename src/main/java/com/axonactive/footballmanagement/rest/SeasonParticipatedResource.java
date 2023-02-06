package com.axonactive.footballmanagement.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(SeasonParticipatedResource.PATH)
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
public class SeasonParticipatedResource {
    public static final String PATH = "leagues/{leagueId}/teams";


}
