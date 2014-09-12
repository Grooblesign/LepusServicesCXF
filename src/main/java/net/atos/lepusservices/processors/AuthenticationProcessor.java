package net.atos.lepusservices.processors;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import net.atos.lepusservices.models.User;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.codehaus.jackson.map.ObjectMapper;

public class AuthenticationProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		User user = new User();
		
		user.setId(2);
		user.setName("Taz");
		user.setPassword("passwordX");
		user.setWibble("12345678");
		
		ObjectMapper mapper = new ObjectMapper();
		
		Response response = null;
		
		try {
			String json = mapper.writeValueAsString(user);
			System.out.println("Json: " + json);
		
			response = Response.ok(json, "application/json").build();
		} catch (Exception exception) {
			System.out.println("Exception: " + exception.getClass() + " - " + exception.getMessage());
			response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		
		exchange.getOut().setBody(response);
	}
}
