package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.entities.SeasonParticipatedEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.rest.request.SeasonParticipatedRequest;
import com.axonactive.footballmanagement.rest.request.TeamPlayedRequest;
import com.axonactive.footballmanagement.service.dto.SeasonParticipatedDto;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(SeasonParticipatedResource.PATH)
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
public class SeasonParticipatedResource {
    public static final String PATH = SeasonResource.PATH + "/{seasonId}/teams";

//    @POST
//    @Path("{teamId}")
//    public Response create(@PathParam("seasonId") Long seasonId,
//                           @PathParam("teamId") Long teamId,
//                           @Valid SeasonParticipatedRequest seasonParticipatedRequest) {
//        try {
//            return Response.status(Response.Status.CREATED).entity(teamPlayedService.createTeamPlayed(teamId, playerId, teamPlayedRequest)).build();
//        } catch (CustomException exception) {
//            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
//        }
//    }

}
