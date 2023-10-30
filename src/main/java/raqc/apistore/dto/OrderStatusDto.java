package raqc.apistore.dto;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;


public class OrderStatusDto {
	
	private Long Id;
	
	private String name;


	private List<OrderDto> orders;


	public OrderStatusDto() {
		super();
	}


	public OrderStatusDto(String name) {
		super();
		this.name = name;
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


	public List<OrderDto> getOrders() {
		return this.orders;
	}


	public void SetOrders(List<OrderDto> orders) {
		this.orders = orders;
	}


	

	
	
	
}
