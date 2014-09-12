package net.atos.lepusservices.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import net.atos.lepusservices.models.AuthenticationUser;
import net.atos.lepusservices.models.User;

@Path("rest/authentication/user")
public class CamelAuthenticationService {

	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public User getUserForCredentialsInJson(AuthenticationUser user) {
		
		return null;
		
	}

}
