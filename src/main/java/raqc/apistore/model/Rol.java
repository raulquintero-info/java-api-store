package raqc.apistore.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@Table(name="roles")
public class Rol implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="rol", cascade = CascadeType.ALL)
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<User> users;

	public Rol() {
		super();
	}

	public Rol(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<User> getUsers() {
//		return users;
//	}

//	public void setUsers(List<User> users) {
//		this.users = users;
//	}

	



	
	
}
