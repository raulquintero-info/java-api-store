package raqc.apistore.dto;

import java.io.Serializable;

import raqc.apistore.model.Human;
import raqc.apistore.model.Rol;

public class UserLoggedDto implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String username;
	private String token;
	private Rol rol;
	private String name;
	
	
	
	
	public UserLoggedDto() {
		super();
	}
	
	public UserLoggedDto(Long id, String username, String token, Rol rol, String name) {
		super();
		this.id = id;
		this.username = username;
		this.token = token;
		this.rol = rol;
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserLoggedDto [id=" + id + ", username=" + username + ", token=" + token + ", rol=" + rol + ", name="
				+ name + "]";
	}
	
	
	
	
	
}
