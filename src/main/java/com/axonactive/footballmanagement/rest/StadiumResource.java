package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.entities.StadiumEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.service.PlayerService;
import com.axonactive.footballmanagement.service.StadiumService;
import com.axonactive.footballmanagement.service.dto.StadiumDto;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path(StadiumResource.PATH)
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
public class StadiumResource extends GenericResource<StadiumEntity, StadiumDto> {
    public static final String PATH = "stadiums";

    @Inject
    private StadiumService stadiumService;

    @POST
    public Response create(@Valid List<StadiumEntity> stadiumEntities) {
        try {
            return Response.status(Response.Status.CREATED).entity(stadiumService.create_toDto(stadiumEntities)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, @Valid StadiumEntity stadiumEntity) {
        try {
            return Response.ok().entity(stadiumService.update_toDto(id, stadiumEntity)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }
}
