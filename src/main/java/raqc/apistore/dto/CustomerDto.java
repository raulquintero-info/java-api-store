package raqc.apistore.dto;

import java.util.Date;
import org.springframework.data.jpa.repository.Query;



public class CustomerDto {

	private Long id;
	private String name;
	private String lastname;
	private String phone;

	
	
	public CustomerDto() {
		super();
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


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", name=" + name + ", lastname=" + lastname + ", phone=" + phone + "]";
	}



	
	
	
	
	
}
