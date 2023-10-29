package raqc.apistore.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@Table (name = "brands") 
public class Brand {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String brandname;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", cascade = CascadeType.ALL)
	private List<Product> products;


	public Brand() {
		super();
	}


	public Brand(String brandname, List<Product> products) {
		super();
		this.brandname = brandname;
		this.products = products;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBrandname() {
		return brandname;
	}


	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}


	public List<Product> getProduct() {
		return this.products;
	}


	public void setProduct(List<Product> products) {
		this.products = products;
	}
	
	
	
	
}
