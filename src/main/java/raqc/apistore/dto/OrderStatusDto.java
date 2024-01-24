package raqc.apistore.dto;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


public class OrderStatusDto {
	

	private Long Id;
	
	private String name;
	private String dotColor;
	private String bgColor;


	
	
	private List<OrderDto> orders;


	public OrderStatusDto() {
		super();
	}


	public OrderStatusDto(Long id, String name) {
		super();
		this.Id = id;
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


	public String getDotColor() {
		return dotColor;
	}


	public void setDotColor(String dotColor) {
		this.dotColor = dotColor;
	}


	public String getBgColor() {
		return bgColor;
	}


	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	
	public List<OrderDto> getOrders() {
	return this.orders;
}

	public void SetOrders(List<OrderDto> orders) {
		this.orders = orders;
	}


	

	
	
	
}
