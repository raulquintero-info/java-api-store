package raqc.apistore.dto;

public class ProductsDto {

	private String name;
	private String descripcion;
	private Float  price;
	private String image;
	private Long categoryId;
	
	public ProductsDto(String name, String descripcion, Float price, String image, Long categoryId) {
		super();
		this.name = name;
		this.descripcion = descripcion;
		this.price = price;
		this.image = image;
		this.categoryId = categoryId;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Long getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
	
	
}
