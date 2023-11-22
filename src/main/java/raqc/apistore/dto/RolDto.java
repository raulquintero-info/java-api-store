package raqc.apistore.dto;

public class RolDto {

	private Long id;
	private String name;
	
	
	
	public RolDto() {
		super();
	}

	public RolDto( String name) {
		super();
		this.name = name;
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

	@Override
	public String toString() {
		return "RolDto [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
