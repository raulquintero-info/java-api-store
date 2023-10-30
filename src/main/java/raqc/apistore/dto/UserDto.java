package raqc.apistore.dto;


public class UserDto {
	
	private Long id;
	private String username;
	private String password;
	private RolDto rol;
	
	
	public UserDto() {
		super();
	}


	public UserDto(Long id, String username, String password, RolDto rol) {
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


	public RolDto getRol() {
		return rol;
	}


	public void setRol(RolDto rol) {
		this.rol = rol;
	}
	
	
	
	
}
