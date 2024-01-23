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
import raqc.apistore.repository.IRoleRepository;
import raqc.apistore.repository.IUserRepository;




@Service
public class CustomerService {

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IRoleRepository roleRepository;
	
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
	
	@Transactional(readOnly = true)
	public Long totalCustomers() {
		return userRepository.countByCustomers();

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
	
	public User create(UserDto customerDto) {
		System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]CustomerService::create() \n     " + customerDto.toString());

		User user = new User();
		Rol customerRol = new Rol();
		
		customerRol.setId(2L);
		
		user.setUsername(customerDto.getUsername());
		user.setPassword(customerDto.getPassword());
		user.setName(customerDto.getName());
		user.setLastname(customerDto.getLastname());
		user.setPhone(customerDto.getPhone());
		user.setRol(customerRol);
		user = userRepository.save(user);
//		
//		customerEntity.setHuman(humanEntity);
		System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]CustomerService::create() \n     " + user);
		return user;
		
	}

	@Transactional
	public User update(UserDto userDto) {
		
		User userEntity = userRepository.findById(userDto.getId())
				.orElseThrow(()-> new NoSuchElementException("Usuario no encontrado con el id: " + userDto.getId()));
		System.out.println("** CustomerService::update() - userDto: \n   " + userDto.toString());
		System.out.println("** CustomerService::update() - userEntity: \n   " + userEntity.toString());
		userEntity.setId(userDto.getId());
		userEntity.setName(userDto.getName());
		userEntity.setPhone(userDto.getPhone());
		userEntity.setLastname(userDto.getLastname());
		
		return userRepository.save(userEntity);
		
		
	}
	
	
	public void delete(Long id) {
		userRepository.deleteById(id);
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
