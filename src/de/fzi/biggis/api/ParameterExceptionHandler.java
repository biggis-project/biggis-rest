package de.fzi.biggis.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import de.fzi.biggis.exceptions.ParameterException;

@Provider
public class ParameterExceptionHandler implements ExceptionMapper<ParameterException> {
	
    public ParameterExceptionHandler() {
        System.out.println("ParameterExceptionHandler created");
    }

	@Override
	public Response toResponse(ParameterException e) {
		System.out.println("ParameterExceptionHandler invoked");
		return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
	}
}
