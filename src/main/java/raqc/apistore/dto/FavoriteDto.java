package raqc.apistore.dto;

import java.util.List;

import raqc.apistore.model.Brand;
import raqc.apistore.model.Category;
import raqc.apistore.model.OrderProducts;
import raqc.apistore.model.User;

public class FavoriteDto {


	private Long id;
	private Long productId;
	private Long userId;
	
	private String name;
	private String description;
	private String image;
	private Double price;
	private Boolean isOffer;
	private Double offerPrice;
	
	

	private Brand brand;
	
	
	private Category category;
	
	

	
	

	

	public FavoriteDto() {
		super();
	}
	
	



	public FavoriteDto(String name, String description, String image, Double price, Integer quantity, Brand brand,
			Category category) {
		super();
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.brand = brand;
		this.category = category;
	}





	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public Long getProductId() {
		return productId;
	}





	public void setProductId(Long productId) {
		this.productId = productId;
	}





	public Long getUserId() {
		return userId;
	}





	public void setUserId(Long userId) {
		this.userId = userId;
	}





	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	

	public Boolean getIsOffer() {
		return isOffer;
	}



	public void setIsOffer(Boolean isOffer) {
		this.isOffer = isOffer;
	}
	



	public Double getOfferPrice() {
		return offerPrice;
	}



	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}





	@Override
	public String toString() {
		return "FavoriteDto [id=" + id + ", productId=" + productId + ", userId=" + userId + ", name=" + name
				+ ", description=" + description + ", image=" + image + ", price=" + price + ", isOffer=" + isOffer
				+ ", offerPrice=" + offerPrice + ", brand=" + brand + ", category=" + category + "]";
	}



	



	
	
	
	
	
	
}
