package raqc.apistore.dto;

//import raqc.apistore.model.Category;

public class ProductDto {

	private Long id;
	private String model;
	private String description;
	private Float  price;
	private Integer quantity;
	private String image;
	private Long brandId;
	private String brand;
	
	

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public ProductDto(long id, String model, String description, float price, Integer quantity, String image, long brandId, String brand) {
		super();
		this.id = id;
		this.model = model;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.brandId = brandId;
		this.brand = brand;
		
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	
	public void setCategoryId(Long brandId) {
		this.brandId = brandId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	

	



	
	
}
