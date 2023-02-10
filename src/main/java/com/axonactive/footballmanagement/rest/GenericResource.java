package com.axonactive.footballmanagement.rest;

import com.axonactive.footballmanagement.entities.IGenericEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.rest.request.TeamRequest;
import com.axonactive.footballmanagement.service.GenericService;
import com.axonactive.footballmanagement.service.dto.IGenericDto;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class GenericResource<T extends IGenericEntity, S extends IGenericDto> {

    @Inject
    private GenericService<T, S> genericService;

    @GET
    public Response findAll() {
        return Response.ok().entity(genericService.findAll_toDto()).build();
    }

    @GET
    @Path("{id}")
    public Response findById(Long id) {
        try {
            return Response.ok().entity(genericService.findById_toDto(id)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @POST
    public Response create(@Valid T entity) {
        try {
            return Response.status(Response.Status.CREATED).entity(genericService.create_toDto(entity)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, @Valid T entity) {
        try {
            return Response.ok().entity(genericService.update_toDto(id, entity)).build();
        } catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        try {
            genericService.delete(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        catch (CustomException exception) {
            return Response.status(exception.getResponse().getStatus()).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }
}
