package raqc.apistore.dto;

import java.io.Serializable;

public class CredentialsDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String email) {
		this.username = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	@Override
	public String toString() {
		return "CredentialsDto [username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
}
