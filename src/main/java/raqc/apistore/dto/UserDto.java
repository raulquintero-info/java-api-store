package raqc.apistore.dto;

import raqc.apistore.model.Human;
import raqc.apistore.model.Rol;


public class UserDto {
	
	private Long id;
	private String username;
	private String password;
	private Rol rol;
	private String token;
	private Boolean isLogged;
	private Human human;
	
	public UserDto() {
		super();
	}

	

	public UserDto(Long id, String username, String password, Rol rol) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.rol = rol;
		
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

	public Boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	public Human getHuman() {
		return human;
	}



	public void setHuman(Human human) {
		this.human = human;
	}
	
	
	
	
}
