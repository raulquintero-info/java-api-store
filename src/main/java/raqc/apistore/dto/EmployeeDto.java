package raqc.apistore.dto;

import java.util.Date;
import org.springframework.data.jpa.repository.Query;


public class EmployeeDto {

	
	private Long id;
	private String department;
	
	public EmployeeDto() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
	
	
}
