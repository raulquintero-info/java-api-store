package raqc.apistore.dto;

public class CategoryDto {

	private Integer id;
	private String name;
	
	
	public CategoryDto() {
		super();
	}

	public CategoryDto(String name) {
		super();
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
}
