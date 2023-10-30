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
	private Human human;
	
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="customertype_id")
//	private CustomerType customerType;
	
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

//	public CustomerType getCustomerType() {
//		return customerType;
//	}
//
//	public void setCustomerType(CustomerType customerType) {
//		this.customerType = customerType;
//	}
	
	
	
}
