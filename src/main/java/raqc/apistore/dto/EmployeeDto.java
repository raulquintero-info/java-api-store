package raqc.apistore.dto;

import java.util.Date;
import org.springframework.data.jpa.repository.Query;


public class EmployeeDto {

	
	private Long id;
	private String department;
	
	private HumanDto human;

	public EmployeeDto() {
		super();
	}

	public EmployeeDto( String department) {
		super();
		this.department = department;
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

	public HumanDto getHuman() {
		return human;
	}

	public void setHumanHumaDto(HumanDto human) {
		this.human = human;
	}
	
	
	
	
	
	
}
