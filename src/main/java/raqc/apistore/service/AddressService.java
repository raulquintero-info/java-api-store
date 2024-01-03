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

import raqc.apistore.dto.AddressDto;
import raqc.apistore.dto.CategoryDto;
import raqc.apistore.model.Address;
import raqc.apistore.model.Category;
import raqc.apistore.model.Order;
import raqc.apistore.model.Product;
import raqc.apistore.repository.IAddressRepository;
import raqc.apistore.repository.IOrderRepository;



@Service
public class AddressService {

	
	@Autowired
	private IAddressRepository addressRepository;
	
	
	
	@Transactional(readOnly = true)
	public List<Address> findAll(){
		System.out.println("hello");
		return (List<Address>)addressRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public  Address findById(Long id) {
		System.out.println("[41]OrderService::findById() \n   id: " + id);
		return (Address) addressRepository.findById(id).get();
	}
	
	@Transactional(readOnly=true)
	public  List<Address> findByUserId(Long id) {
		System.out.println("[41]OrderService::findById() \n   id: " + id);
		return (List<Address>) addressRepository.findByUserId(id);
	}
	
	@Transactional
	public Address create(AddressDto addressDto) {
		
		Address addressEntity = new Address();
		
		addressEntity.setAlias(addressDto.getAlias());
		addressEntity.setAddress1(addressDto.getAddress1());
		addressEntity.setAddress2(addressDto.getAddress2());
		addressEntity.setCity(addressDto.getCity());
		addressEntity.setCountry(addressDto.getCountry());
		addressEntity.setZipCode(addressDto.getZipCode());
		addressEntity.setUser(addressDto.getUser());
		return addressRepository.save(addressEntity);
		
		
	}
//	
//	@Transactional
//	public Category update(CategoryDto categoryDto) {
//		
//		Category productEntity = categoryRepository.findById(categoryDto.getId())
//				.orElseThrow(()-> new NoSuchElementException("Categoria no encontrado con el id: " + categoryDto.getId()));
//		
//		productEntity.setId(categoryDto.getId());
//		productEntity.setName(categoryDto.getName());
//		productEntity.setPosition(categoryDto.getPosition());
//		productEntity.setQuantity(categoryDto.getQuantity());
//		productEntity.setIsEnabled(categoryDto.getIsEnabled());
//		
//		return categoryRepository.save(productEntity);
//		
//		
//	}
	
	public void delete(Long id) {
		addressRepository.deleteById(id);
	}
	
	
	
	
}
