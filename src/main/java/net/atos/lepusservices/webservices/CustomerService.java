package net.atos.lepusservices.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import net.atos.lepusservices.models.User;

@Path("wibble")
public class CustomerService {
	@GET
	@Produces("application/json")
	@Path("/")
	public Response getCustomer() {
	    return null;
	}
}
