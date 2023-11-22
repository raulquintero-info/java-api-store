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

import raqc.apistore.dto.EmployeeDto;
import raqc.apistore.model.Employee;
import raqc.apistore.model.Human;
import raqc.apistore.model.Product;
import raqc.apistore.repository.IEmployeeRepository;
import raqc.apistore.repository.IHumanRepository;




@Service
public class EmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Autowired 
	private IHumanRepository humanRepository;
	
	@Transactional(readOnly = true)
	public List<Employee> findAll(){
		return (List<Employee>)employeeRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
	}
	
	
	
	
	
	
	
	public Employee create(EmployeeDto employee) {
	
		Employee employeeEntity = new Employee();
		Human humanEntity = employee.getHuman();
		
		humanEntity = humanRepository.save(humanEntity);
		
		employeeEntity.setHuman(humanEntity);
		System.out.println(employeeEntity.toString());
		return employeeRepository.save(employeeEntity);
		
	}
	
	
	
	@Transactional(readOnly=true)
	public  Employee findById(Long id) {
		System.out.println("error en service: "+ id);
		return (Employee) employeeRepository.findById(id).get();
	}
	

	@Transactional
	public Employee update(EmployeeDto employeeDto) {
		Human humanEntity;

		Employee employeeEntity = employeeRepository.findById(employeeDto.getId())
				.orElseThrow(()-> new NoSuchElementException("Producto no encontrado con el id: " + employeeDto.getId()));
		
//		productEntity.setId(productDto.getId());
//		productEntity.setName(productDto.getName());
//		productEntity.setDescription(productDto.getDescription());
//		productEntity.setImage(productDto.getImage());
//		productEntity.setPrice(productDto.getPrice());
//		productEntity.setQuantity(productDto.getQuantity());
//		productEntity.setBrand(productDto.getBrand());
//		productEntity.setCategory(productDto.getCategory());
		humanEntity = humanRepository.save(employeeDto.getHuman());
		employeeEntity.setHuman(humanEntity);
		return employeeRepository.save(employeeEntity);
		
		
	}
	
	
	
}
