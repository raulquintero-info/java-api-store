package raqc.apistore.model;

import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String area;
	
	@OneToOne
	@JoinColumn(name = "human_id")
	private Human human;

	public Employee() {
		super();
	}

	public Employee(Long id, String area, Human human) {
		super();
		this.id = id;
		this.area = area;
		this.human = human;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Human getHuman() {
		return human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}
	
	
	
	
	
	
}
