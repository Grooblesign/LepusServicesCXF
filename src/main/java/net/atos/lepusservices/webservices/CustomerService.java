package net.atos.lepusservices.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("wibble")
public class CustomerService {
	@GET
	@Path("/")
	public String getCustomer() {
	    return "Hello";
	}
}
