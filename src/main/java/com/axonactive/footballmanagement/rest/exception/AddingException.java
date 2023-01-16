package com.axonactive.footballmanagement.rest.exception;

import javax.ejb.ApplicationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationException(rollback = true)
public class AddingException extends WebApplicationException {
    public AddingException(String message, Response.Status status) {
        super(message, status);
    }

}
