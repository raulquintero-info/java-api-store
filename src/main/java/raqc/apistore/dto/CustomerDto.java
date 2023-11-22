package raqc.apistore.dto;

import java.util.Date;
import org.springframework.data.jpa.repository.Query;

import raqc.apistore.model.Human;


public class CustomerDto {

	private Long id;

	private Human human;
	
	public CustomerDto() {
		super();
	}

	public CustomerDto(Long id) {
		super();
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Human getHuman() {
		return human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}

	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", human=" + human + "]";
	}
	
	
	
	
}
