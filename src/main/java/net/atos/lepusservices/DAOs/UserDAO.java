package net.atos.lepusservices.DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import net.atos.lepusservices.models.User;
import net.atos.lepusservices.util.ConnectionFactory;

public class UserDAO {

	public User findByWibble(String wibble) {
		
		User user = null;
		
		try {
			Connection connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM user WHERE Wibble='%s'", wibble));
			
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
