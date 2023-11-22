package raqc.apistore.model;



import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="customertype")
public class CustomerType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy="customertype", cascade = CascadeType.ALL)
//	private List<Customer> customers;
	
	
	
	public CustomerType() {
		super();
	}

	

	public CustomerType(String name) {
		super();
		this.name = name;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



//	public List<Customer> getCustomers() {
//		return customers;
//	}
//
//
//
//	public void setCustomers(List<Customer> customers) {
//		this.customers = customers;
//	}
	
	
	
	
	
}
