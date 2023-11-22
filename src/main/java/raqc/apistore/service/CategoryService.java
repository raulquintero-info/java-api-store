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

import raqc.apistore.dto.CategoryDto;
import raqc.apistore.model.Category;
import raqc.apistore.repository.ICategoryRepository;




@Service
public class CategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Transactional(readOnly = true)
	public List<Category> findAll(){
		return (List<Category>)categoryRepository.findAll(Sort.by(Sort.Direction.ASC,"position"));
	}
	
	@Transactional(readOnly = true)
	public List<Category> getCategoriesEnabled(){
		return categoryRepository.getCategoriesEnabled();
	}
	
	@Transactional(readOnly=true)
	public  Category findById(Long id) {
		return (Category) categoryRepository.findById(id).get();
	}
	
	
	

	@Transactional
	public Category create(CategoryDto categoryDto) {
		
		Category productEntity = new Category();
		
//		productEntity.setId(categoryDto.getId());
		productEntity.setName(categoryDto.getName());
		return categoryRepository.save(productEntity);
		
		
	}
	
	@Transactional
	public Category update(CategoryDto categoryDto) {
		
		Category productEntity = categoryRepository.findById(categoryDto.getId())
				.orElseThrow(()-> new NoSuchElementException("Categoria no encontrado con el id: " + categoryDto.getId()));
		
		productEntity.setId(categoryDto.getId());
		productEntity.setName(categoryDto.getName());
		productEntity.setPosition(categoryDto.getPosition());
		productEntity.setQuantity(categoryDto.getQuantity());
		productEntity.setIsEnabled(categoryDto.getIsEnabled());
		
		return categoryRepository.save(productEntity);
		
		
	}
	
	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}
	
	public void plusOneQuantityProducts(Long categoryId) {
		System.out.println("categoryId" + categoryId);
		categoryRepository.plusOneQuantityProduct(categoryId);
	}
	
	public void minusOneQuantityProducts(Long categoryId) {
		categoryRepository.minusOneQuantityProduct(categoryId);
	}
	

	
}
