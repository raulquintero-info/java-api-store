package raqc.apistore.dto;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import raqc.apistore.model.Brand;


public class OrderProductsDto {

	
	private Long id;
	private Integer quantity;
	private Brand brand;
	private Double price;
	private String image;
	private Long productId;
	private Boolean isOffer;
	private String name;
	private Double offerPrice;
	
	
	private OrderDto order;
	


	public OrderProductsDto() {
		super();
	}

	public OrderProductsDto(Integer quantity, Double price, OrderDto order) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	


	public Boolean getIsOffer() {
		return isOffer;
	}

	public void setIsOffer(Boolean isOffer) {
		this.isOffer = isOffer;
	}



	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
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
	
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public OrderDto getOrder() {
		return order;
	}

	public void setOrder(OrderDto order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderProductsDto [id=" + id + ", quantity=" + quantity + ", brand=" + brand + ", price=" + price
				+ ", image=" + image + ", productId=" + productId + ", isOffer=" + isOffer + ", name=" + name
				+ ", offerPrice=" + offerPrice + ", order=" + order + "]";
	}

	


	
	
	
	
	
	
	
}
