package raqc.apistore.model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;


@Entity
@Table (name = "carts") 

public class Cart {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date date;
	
	private Double tax;
	private Double shipping;
	private Double total;
	
	
//	private Customer customer;
	
	
	
	
}
