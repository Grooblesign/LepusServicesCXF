package net.atos.lepusservices.webservices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.atos.lepusservices.models.User;
import net.atos.lepusservices.util.ConnectionFactory;

@Path("/user")
public class UserService {
	
	@GET
	@Path("/")
	@Produces("application/json")
	public Collection<User> getUsers() {
		
		List<User> users = new ArrayList<User>();

		try {
			Connection connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM user ORDER BY Id");
			
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("Name"));
				user.setPassword(resultSet.getString("Password"));
				user.setWibble(resultSet.getString("Wibble"));

				users.add(user);
			}

			statement.close();
			connection.close();
		} catch (Exception exception) {
			System.out.println("Exception: " + exception.getClass().toString()
					+ " - " + exception.getMessage());
		}
		
		return users;
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public User getUser(@PathParam("id") int id) {
		
		User user = null;
		
		try {
			Connection connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM user WHERE Id=%s", id));
			
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("Name"));
				user.setPassword(resultSet.getString("Password"));
				user.setWibble(resultSet.getString("Wibble"));
			}
			statement.close();
			connection.close();
		} catch (Exception exception) {
			System.out.println("Exception: " + exception.getClass().toString()
					+ " - " + exception.getMessage());
		}
		
		return user;
	}
}
