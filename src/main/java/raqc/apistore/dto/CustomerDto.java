package raqc.apistore.dto;

import java.util.Date;
import org.springframework.data.jpa.repository.Query;


public class CustomerDto {

	private Long id;

	private CustomerTypeDto customertype;
	private HumanDto human;
	
	public CustomerDto() {
		super();
	}

	public CustomerDto(Long id) {
		super();
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerTypeDto getCustomertype() {
		return customertype;
	}

	public void setCustomertype(CustomerTypeDto customertype) {
		this.customertype = customertype;
	}

	public HumanDto getHuman() {
		return human;
	}

	public void setHuman(HumanDto human) {
		this.human = human;
	}
	
	
	
	
}
