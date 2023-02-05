package com.axonactive.footballmanagement.rest;


import com.axonactive.footballmanagement.entities.LeagueEntity;
import com.axonactive.footballmanagement.entities.SeasonEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.service.LeagueService;
import com.axonactive.footballmanagement.service.SeasonService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(LeagueResource.PATH)
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
public class LeagueResource {
    public static final String PATH = "leagues";

    @Inject
    private LeagueService leagueService;

    @Inject
    private SeasonService seasonService;

    @GET
    public Response findAllLeagues() {
        return Response.ok().entity(leagueService.findAll_ToLeagueDto()).build();
    }

    @GET
    @Path("{id}")
    public Response findLeagueById(Long id) {
        try {
            return Response.ok().entity(leagueService.findById_ToLeagueDto(id)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @POST
    public Response createLeague(@Valid LeagueEntity league) {
        try {
            return Response.status(Response.Status.CREATED).entity(leagueService.createLeague(league)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response updateLeague(@PathParam("id") Long id, @Valid LeagueEntity league) {
        try {
            return Response.ok().entity(leagueService.updateLeague(id, league)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteLeague(@PathParam("id") Long id) {
        try {
            leagueService.deleteLeague(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

//    @GET
//    @Path("{id}/seasons")
//    public Response findAllSeasonByLeagueId(Long id) {
//        try {
//            return Response.ok().entity(seasonService.findById_ToSeasonDto(id)).build();
//        } catch (CustomException exception) {
//            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
//        }
//    }
}
