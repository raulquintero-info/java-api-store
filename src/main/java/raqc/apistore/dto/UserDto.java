package raqc.apistore.dto;

import java.util.List;

import raqc.apistore.model.Product;
import raqc.apistore.model.Rol;


public class UserDto {
	
	private Long id;
	private String username;
	private String password;
	private String name;
	private String lastname;
	private String phone;
	private Rol rol;
	private String token;
	private Boolean isLogged;
	

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
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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



	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", lastname=" + lastname + ", phone=" + phone + ", rol=" + rol + ", token=" + token + ", isLogged="
				+ isLogged + "]";
	}





	
	




	
}
