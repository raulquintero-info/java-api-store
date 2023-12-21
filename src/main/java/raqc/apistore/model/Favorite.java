package raqc.apistore.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;


@Entity
@Table (name = "favorites") 
public class Favorite implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long userId;
	private Long productId;
	
	



	public Favorite() {
		super();
	}


	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}





	public Long getUserId() {
		return userId;
	}





	public void setUserId(Long userId) {
		this.userId = userId;
	}





	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}





	@Override
	public String toString() {
		return "Favorite [id=" + id + ", userId=" + userId + ", productId=" + productId + "]";
	}







	








	
	
	
	
}
