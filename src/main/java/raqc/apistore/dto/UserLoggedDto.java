package raqc.apistore.dto;

import java.io.Serializable;

public class UserLoggedDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String email;
	private String name;
	private String lastName;
	private String role;
	
	
	
	public UserLoggedDto(Integer id, String email, String name, String lastName, String role) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
}
