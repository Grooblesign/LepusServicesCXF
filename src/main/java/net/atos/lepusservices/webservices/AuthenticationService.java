package net.atos.lepusservices.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import net.atos.lepusservices.DAOs.UserDAO;
import net.atos.lepusservices.models.AuthenticationUser;
import net.atos.lepusservices.models.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/authentication")
public class AuthenticationService {
	
	static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

	@POST
	@Path("/wibble")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getUserForWibbleInJson(AuthenticationUser user) {

		return getUserForWibble(user.getWibble());
		
	}
	
	@POST
	@Path("/wibble")
	@Produces("application/xml")
	public Response getUserForWibbleInXML(@FormParam("wibble") String wibble) {

		return getUserForWibble(wibble);
		
	}

	private Response getUserForWibble(String wibble) {
		
		logger.info("getUserForWibble in");
		
		Response response= null;

		UserDAO userDAO = new UserDAO();
		
		try {
			User user = userDAO.findByWibble(wibble);
			
			if (user == null) {
				response = Response.status(Status.NOT_FOUND).build();;
			} else {
				response = Response.ok(user).build();
			}
		} catch (Exception exception) {
			logger.error("Exception: " + exception.getClass().toString() + " - " + exception.getMessage());;
		}
		
		logger.info("getUserForWibble out");

		return response;
	}
	
	@POST
	@Path("/user")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getUserForCredentialsInJson(AuthenticationUser user) {
		
		return getUserForCredentials(user.getUsername(), user.getPassword());
		
	}
	
	private Response getUserForCredentials(String username, String password) {

		logger.info("CXF: getUserForCredentials in");

		Response response= null;

		UserDAO userDAO = new UserDAO();
		
		try {
			User user = userDAO.findByName(username);
			
			if (user != null && !user.getPassword().equals(password)) {
				user = null;
			}

			if (user == null) {
				response = Response.status(Status.NOT_FOUND).build();
			} else {
				response = Response.ok(user).build();
			}
		} catch (Exception exception) {
			logger.error("Exception: " + exception.getClass().toString() + " - " + exception.getMessage());
		}
		
		logger.info("CXF: getUserForCredentials out");
		
		return response;
	}
}
