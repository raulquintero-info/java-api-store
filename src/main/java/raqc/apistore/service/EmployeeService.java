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

import raqc.apistore.dto.BrandDto;
import raqc.apistore.dto.CategoryDto;
import raqc.apistore.dto.CustomerDto;
import raqc.apistore.dto.RolDto;
import raqc.apistore.dto.UserDto;
import raqc.apistore.dto.UserLoggedDto;
import raqc.apistore.model.Brand;
import raqc.apistore.model.Category;

import raqc.apistore.model.Product;
import raqc.apistore.model.Rol;
import raqc.apistore.model.User;
import raqc.apistore.repository.IUserRepository;




@Service
public class EmployeeService {

	@Autowired
	private IUserRepository userRepository;
	
	@Transactional(readOnly = true)
	public List<User> findAll(){
		return (List<User>)userRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
	}
	

	public List<User> findAllCustomers(){
		return (List<User>)userRepository.findAllCustomers();
	}
	
	public List<User> findAllEmployees(){
		return (List<User>)userRepository.findAllEmployees();
	}
	
	
	@Transactional(readOnly=true)
	public  User findById(Long id) {
		
		User user = userRepository.findById(id).get();
		user.setPassword("");
		
		return user;
	}
	
	@Transactional(readOnly = true)
	public User findByUsername(String username) {
		
		return userRepository.findByUserName(username);
	
	}	
	
	public User create(User userDto) {
		
		User userEntity = new User();
		userEntity.setId(userDto.getId());
//		userEntity.setHuman(userDto.getHuman());
		userEntity.setRol(userDto.getRol());
//		userEntity.setUsername(userDto.getHuman().getEmail());
//		Human humanEntity = userDto.getHuman();
//		humanEntity = humanRepository.save(humanEntity);
		userEntity = userRepository.save(userEntity);
		
//		customerEntity.setHuman(humanEntity);
//		System.out.println(customerEntity.toString());
		return userRepository.save(userDto);
		
	}

	@Transactional
	public User update(UserDto userDto) {
		
		User userEntity = userRepository.findById(userDto.getId())
				.orElseThrow(()-> new NoSuchElementException("Categoria no encontrado con el id: " + userDto.getId()));
		
//		userEntity.setId(userDto.getId())
		userEntity.setName(userDto.getName());
		userEntity.setLastname(userDto.getLastname());
		userEntity.setUsername(userDto.getUsername());
		if(userDto.getToken() != "") userEntity.setToken(userDto.getToken());
		if(userDto.getPassword() != "") userEntity.setPassword(userDto.getPassword());
		if(userDto.getRol().getId() >= 0) userEntity.setRol(userDto.getRol());
		
		return userRepository.save(userEntity);
		
		
	}
	
	
	
	
	
	@Transactional
	public User validateToken(String token) {
		
		return userRepository.findUserByToken(token);
		
		
	}
	
	@Transactional
	public User updateToken(User user) {
		
		user.setToken(user.getToken());
		return userRepository.save(user);	
	}
	

	
	
	
	
	@Transactional
	public void updateHumanId(Long humanId, Long userId) {
		userRepository.updateHumanId(humanId, userId);
		
	}
	
	
}
