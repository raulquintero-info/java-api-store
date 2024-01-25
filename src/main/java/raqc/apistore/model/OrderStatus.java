package raqc.apistore.model;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="orderstatus")
public class OrderStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private String name;
	private String dotColor;
	private String bgColor;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderstatus", cascade = CascadeType.ALL)
	
	private List<Order> orders;


	public OrderStatus() {
		super();
	}


	public OrderStatus(Long id, String name) {
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

	
//	public List<Order> getOrders() {
//	return this.orders;
//}

	public void SetOrders(List<Order> orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "OrderStatus [Id=" + Id + ", name=" + name + ", dotColor=" + dotColor + ", bgColor=" + bgColor
				+ ", orders=" + orders + "]";
	}


	

	
	
	
}
