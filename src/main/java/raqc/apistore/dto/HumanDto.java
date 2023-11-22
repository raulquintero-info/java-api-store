package raqc.apistore.dto;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import raqc.apistore.model.Customer;
import raqc.apistore.model.Employee;
import raqc.apistore.model.User;


public class HumanDto {

	private Long Id;
	private String name;
	private String lastname;
	private String email;
	private String address1;
	private String address2;
	private String city;
	private String country;
	private String telephone;
	private Integer postalcode;

	
//	private Customer customer;
//
//
//	private Employee employee;
	
	private User user;

//	@OneToOne(mappedBy = "user")
//	private User user;
	
	
	
	public HumanDto() {
		super();
	}

	public HumanDto(String name, String lastname, String email, String address1, String address2, String city,
			String country, String telephone, Integer postalcode,Customer customer, Employee employee, User user) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.country = country;
		this.telephone = telephone;
		this.postalcode = postalcode;
//		this.customer = customer;
//		this.employee = employee;
		this.user = user;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(Integer postalcode) {
		this.postalcode = postalcode;
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "HumanDto [Id=" + Id + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", address1="
				+ address1 + ", address2=" + address2 + ", city=" + city + ", country=" + country + ", telephone="
				+ telephone + ", postalcode=" + postalcode + ", user=" + user + "]";
	}

	
	
}
