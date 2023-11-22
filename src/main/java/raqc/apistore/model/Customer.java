package raqc.apistore.model;

import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;


	@OneToOne
	@JoinColumn(name = "human_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

	private Human human;
	
	
	public Customer() {
		super();
	}

	public Customer(Long id, Human human) {
		super();
		this.id = id;
		this.human = human;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Human getHuman() {
		return human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", human=" + human + "]";
	}

	
}
