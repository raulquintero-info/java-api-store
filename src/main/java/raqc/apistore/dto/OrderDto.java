package raqc.apistore.dto;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;



public class OrderDto {

	private Long Id;
	private Date date;
	private String address1;
	private String address2;
	private String city;
	private String country;
	private Double total;
	
	
	private OrderStatusDto orderstatus;
	
	private List<OrderProductsDto> orderproducts;

	public OrderDto() {
		super();
	}

	public OrderDto(Date date, String address1, String address2, String city, String country, Double total,
			OrderStatusDto orderstatus) {
		super();
		this.date = date;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.country = country;
		this.total = total;
		this.orderstatus = orderstatus;
		this.orderproducts = orderproducts;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public OrderStatusDto getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(OrderStatusDto orderstatus) {
		this.orderstatus = orderstatus;
	}

	public List<OrderProductsDto> getOrderproducts() {
		return orderproducts;
	}

	public void setOrderproducts(List<OrderProductsDto> orderproducts) {
		this.orderproducts = orderproducts;
	}
	
	
	
	
	
	
	
}