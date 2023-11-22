package raqc.apistore.service;

import  java.util.NoSuchElementException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import raqc.apistore.dto.CustomerDto;
import raqc.apistore.model.Customer;
import raqc.apistore.model.Human;
import raqc.apistore.model.Rol;
import raqc.apistore.model.User;
import raqc.apistore.repository.ICustomerRepository;
import raqc.apistore.repository.IHumanRepository;
import raqc.apistore.repository.IUserRepository;




@Service
public class CustomerService {

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Autowired IHumanRepository humanRepository;
	@Autowired IUserRepository userRepository;
	
	@Transactional(readOnly = true)
	public List<Customer> findAll(){
		return (List<Customer>)customerRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
	}
	
	
	
	
	
	
	
	public Customer create(CustomerDto customer) {
	
		Customer customerEntity = new Customer();
		Human humanEntity = customer.getHuman();
		User userEntity = new User();
		Rol rolEntity = new Rol();
		
		rolEntity.setId(1L);
		userEntity.setRol(rolEntity);
		userEntity.setUsername(humanEntity.getEmail());
		userEntity = userRepository.save(userEntity);
		System.out.println(userEntity.toString());
		humanEntity.setUser(userEntity);
		humanEntity = humanRepository.save(humanEntity);
		
		customerEntity.setHuman(humanEntity);
		System.out.println(customerEntity.toString());
		return customerRepository.save(customerEntity);
		
	}
	
	
	
	@Transactional(readOnly=true)
	public  Customer findById(Long id) {
		System.out.println("error en service: "+ id);
		return (Customer) customerRepository.findById(id).get();
	}
	

	@Transactional
	public Customer update(CustomerDto customerDto) {
		Human humanEntity;
		

		Customer customerEntity = customerRepository.findById(customerDto.getId())
				.orElseThrow(()-> new NoSuchElementException("Producto no encontrado con el id: " + customerDto.getId()));
		

		humanEntity = humanRepository.save(customerDto.getHuman());
		customerEntity.setHuman(humanEntity);
		return customerRepository.save(customerEntity);
		
		
	}
	
	public void delete(Long id) {
		customerRepository.deleteById(id);
	}
	
	
}
