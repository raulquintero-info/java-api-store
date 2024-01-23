package raqc.apistore.model;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@Table(name="orderproducts")
public class OrderProducts {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer quantity;
	private String brand;
	private Boolean isOffer;
	private String name;
	private Double offerPrice;
	private Double price;
	private String image;
	private Long productId;
	
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="order_id")
	@JsonBackReference
	private Order order;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="product_id")
//	private Product product;

	public OrderProducts() {
		super();
	}

	public OrderProducts(Integer quantity, Double price, Order order) {
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	public String getName() {
		return name;
	}

	public Boolean getIsOffer() {
		return isOffer;
	}

	public void setIsOffer(Boolean isOffer) {
		this.isOffer = isOffer;
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

	public Order getOrder() {
		return order;
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

//	public Order getOrder() {
//		return order;
//	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderProducts [id=" + id + ", quantity=" + quantity + ", isOffer=" + isOffer + ", name=" + name
				+ ", offerPrice=" + offerPrice + ", price=" + price + ", image=" + image + ", productId=" + productId
				+ "]";
	}


	
	
}
