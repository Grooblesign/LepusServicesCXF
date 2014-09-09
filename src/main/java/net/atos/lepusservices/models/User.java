package net.atos.lepusservices.models;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "User")
public class User {

	int id;
	String name;
	@XmlTransient
	String password;
	String wibble;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWibble() {
		return wibble;
	}

	public void setWibble(String wibble) {
		this.wibble = wibble;
	}
}
