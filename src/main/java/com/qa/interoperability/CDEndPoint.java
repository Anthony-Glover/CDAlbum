package com.qa.interoperability;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.CDService;
import com.qa.persistence.domain.CD;
import com.qa.util.JSONUtil;

@Path("/cd")
public class CDEndPoint 
{
	@Inject
	private CDService service;

	@Inject
	private JSONUtil util;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllCDs() 
	{
		Collection<CD> cds = service.getAllCDs();
		String str = util.getJSONForObject(cds);
		return str;
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addCD(String cd) 
	{
		CD anCD = util.getObjectForJSON(cd, CD.class);
		return service.addCD(anCD);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id, String cd) 
	{
		CD anCD = util.getObjectForJSON(cd, CD.class);
		return service.updateCD(id, anCD);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteCD(@PathParam("id") Long id) 
	{
		return service.deleteCD(id);
	}

	public void setService(CDService service) {
		this.service = service;
	}

}
