package de.fzi.biggis.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import de.fzi.biggis.exceptions.ParameterException;
import de.fzi.biggis.model.Lubw;

@Path("/rest")
public class Rest {
	
	// This method is called if HTML is requested
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHtml(@Context UriInfo info) throws ParameterException {
		Lubw lubw = new Lubw(info.getQueryParameters());
//		return System.getProperty("user.dir");
		return lubw.getHtml();
	}
	@GET
	@Path("/html")
	@Produces(MediaType.TEXT_HTML)
	public String getHtmlPath(@Context UriInfo info) throws ParameterException {
		Lubw lubw = new Lubw(info.getQueryParameters());
		return lubw.getHtml();
	}
	
	
	// This method is called if TEXT_PLAIN is requested
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCsv(@Context UriInfo info) throws ParameterException {
		Lubw lubw = new Lubw(info.getQueryParameters());
		return lubw.getCsv();	    
	}
	@GET
	@Path("/csv")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCsvPath(@Context UriInfo info) throws ParameterException {
		Lubw lubw = new Lubw(info.getQueryParameters());
		return lubw.getCsv();	    
	}
	
	// This method is called if JSON is requested
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getJson(@Context UriInfo info) throws ParameterException {
		Lubw lubw = new Lubw(info.getQueryParameters());
		return lubw.getJson();	    
	}
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String getJsonPath(@Context UriInfo info) throws ParameterException {
		Lubw lubw = new Lubw(info.getQueryParameters());
		return lubw.getJson();	    
	}
}
