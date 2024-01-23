package raqc.apistore.dto;

import java.io.Serializable;
import java.util.List;

import raqc.apistore.model.Brand;
import raqc.apistore.model.Category;
import raqc.apistore.model.User;

//import raqc.apistore.model.Category;

public class ProductDto implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String name;
	private String description;
	private Double  price;
	private Integer quantity;
	private String image;
	private Brand brand;
	private Boolean isOffer;
	private Boolean isFavorite;
	private Double offerPrice;
	private Category category;
	private List<User> users;
	

	

	public ProductDto( String name, String description, Double price, Integer quantity, String image, Brand brand, Category category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.brand = brand;
		this.category = category;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String model) {
		this.name = model;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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

	
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	
	
	public Boolean getIsOffer() {
		return isOffer;
	}


	public void setIsOffer(Boolean isOffer) {
		this.isOffer = isOffer;
	}


	public Boolean getIsFavorite() {
		return isFavorite;
	}


	public void setIsFavorite(Boolean isFavorite) {
		this.isFavorite = isFavorite;
	}


	public Double getOfferPrice() {
		return offerPrice;
	}


	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	

	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + ", image=" + image + ", brand=" + brand + ", isOffer=" + isOffer
				+ ", offerPrice=" + offerPrice + ", category=" + category + "]";
	}
	



	
	
}
