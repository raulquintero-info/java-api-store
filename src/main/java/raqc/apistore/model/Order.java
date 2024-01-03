package raqc.apistore.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private Date date;
	private String address1;
	private String address2;
	private String city;
	private String country;
	private Double total;
	private boolean pickup;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orderstatus_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private OrderStatus orderstatus;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderProducts> orderproducts;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private User user;
	
	
	


	public Order() {
		super();
	}

	public Order(Date date, String address1, String address2, String city, String country, Double total,
			OrderStatus orderstatus, List<OrderProducts> orderproducts) {
		super();
		this.date = new Date();
	
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

	public OrderStatus getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(OrderStatus orderstatus) {
		this.orderstatus = orderstatus;
	}

	public List<OrderProducts> getOrderproducts() {
		return orderproducts;
	}

	public void setOrderproducts(List<OrderProducts> orderproducts) {
		this.orderproducts = orderproducts;
	}
	
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean getPickup() {
		return pickup;
	}

	public void setPickup(boolean pickup) {
		this.pickup = pickup;
	}


	
	
	
	
}
