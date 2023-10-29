package raqc.apistore.model;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="orderstatus")
public class OrderStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private String name;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderstatus", cascade = CascadeType.ALL)
	private List<Order> orders;


	public OrderStatus() {
		super();
	}


	public OrderStatus(String name, List<Order> orders) {
		super();
		this.name = name;
		this.orders = orders;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Order> getOrders() {
		return this.orders;
	}


	public void SetOrders(List<Order> orders) {
		this.orders = orders;
	}


	

	
	
	
}
