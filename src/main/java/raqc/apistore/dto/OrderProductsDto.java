package raqc.apistore.dto;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;


public class OrderProductsDto {

	
	private Long id;
	private Integer quantity;
	private Double price;
	
	
	
	private OrderDto order;
	
	private ProductDto product;

	public OrderProductsDto() {
		super();
	}

	public OrderProductsDto(Integer quantity, Double price, OrderDto order, ProductDto product) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.order = order;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public OrderDto getOrder() {
		return order;
	}

	public void setOrder(OrderDto order) {
		this.order = order;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}
	
	
	
	
}
