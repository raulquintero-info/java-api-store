package raqc.apistore.model;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;
	private String image;
	private Double price;
	private Integer quantity;
	private Boolean isOffer;
	private Long isFavorite;
	private Double offerPrice;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="brand_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Brand brand;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

	private Category category;
	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="product", cascade = CascadeType.ALL)
	private List<OrderProducts> orderproducts;


	
	
	public Product() {
		super();
	}
	
	

	public Product(String name, String description, String image, Double price, Integer quantity, Brand brand,
			Category category, List<OrderProducts> orderproducts) {
		super();
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.category = category;
		this.orderproducts = orderproducts;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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



//	public List<OrderProducts> getOrderproducts() {
//		return orderproducts;
//	}

	public void setOrderproducts(List<OrderProducts> orderproducts) {
		this.orderproducts = orderproducts;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + ", price="
				+ price + ", quantity=" + quantity + ", isOffer=" + isOffer + ", offerPrice=" + offerPrice + ", brand="
				+ brand + ", category=" + category + ", orderproducts=" + orderproducts + "]";
	}


	
	
	
	
	
	
}
