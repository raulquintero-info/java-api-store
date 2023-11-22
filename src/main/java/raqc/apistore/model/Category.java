package raqc.apistore.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@Table(name="categories")
public class Category {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer position;
	private Integer quantity;
	private Boolean isEnabled;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="category", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Product> products;

	public Category() {
		super();
	}

	public Category( String name, Integer position) {
		super();
		this.name = name;
		this.position = position;
		
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

	
	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", position=" + position + ", quantity=" + quantity
				+ ", isEnabled=" + isEnabled + ", products=" + products + "]";
	}


	
	
	
	

	
	
	
	
}
