package raqc.apistore.model;

import java.io.Serializable;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String token;
	private Boolean isLogged;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="rol_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Rol rol;
	
	@OneToOne
	@JoinColumn(name = "human_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Human human;

	
	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", token=" + token
				+ ", isLogged=" + isLogged + ", rol=" + rol + ", human=" + human + "]";
	}



//	public Human getHuman() {
//		return human;
//	}

	public void setHuman(Human human) {
		this.human = human;
	}

	
	


	
	
	
}
