package raqc.apistore.dto;

import java.util.Date;
import java.util.List;



public class BrandDto {

	
	private Long id;
	private String brandname;
	
	
	private List<ProductDto> products;


	public BrandDto() {
		super();
	}


	public BrandDto(String brandname) {
		super();
		this.brandname = brandname;
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


	public List<ProductDto> getProduct() {
		return this.products;
	}


	public void setProduct(List<ProductDto> products) {
		this.products = products;
	}
	
	
	
	
}
