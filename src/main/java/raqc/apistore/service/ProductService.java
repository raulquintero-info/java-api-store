package raqc.apistore.service;

import  java.util.NoSuchElementException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import raqc.apistore.dto.ProductDto;
import raqc.apistore.model.Favorite;
import raqc.apistore.model.Product;
import raqc.apistore.repository.IFavoriteRepository;
import raqc.apistore.repository.IProductRepository;




@Service
public class ProductService {

	@Autowired
	private IProductRepository productRepository;
	
	@Autowired IFavoriteRepository favoriteRepository;
	
	@Transactional(readOnly = true)
	public List<Product> findAll(){
		return (List<Product>)productRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
	}
	
	@Transactional(readOnly = true)
	public List<Product> findAllProducts(Integer categoryId, String page){
		
		return (List<Product>)productRepository.findAllProducts(categoryId);
	}
	
	
	@Transactional(readOnly = true)
	public Long getCount() {
		return productRepository.count();
	}
	
	
	@Transactional(readOnly = true)
	public List<Product> findAllOffers(){
		return (List<Product>)productRepository.findAllOffers();
	}
	

	
	
	@Transactional(readOnly = true)
	public List<Product> findAllNew(){
		return (List<Product>)productRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
	}
	
	@Transactional(readOnly = true)
	public Page<Product> findAllPage(Pageable pageable){
		return productRepository.findAll(pageable);
	}
	

	@Transactional(readOnly=true)
	public  Product findById(Long id) {
		System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]ProductService::findById() \n     "
				+ "id: " + id);
		
		
		return (Product) productRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Producto no encontrado con el id: " + id));
	}
	
			
	
	@Transactional(readOnly=true)
	public  Product findFavoriteByUserId(Long productId, Long userId) {
		return (Product) productRepository.findFavoriteByUserId(productId, userId);
	}
	
	@Transactional(readOnly=true)
	public  List<Product> findFavoritesByUserId(List<Integer> arFavorites) {
		if(arFavorites.size()==0) {
			
			System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]ProductService::findById() \n     "
					+ "favorites: " + arFavorites.size());
		}
		return (List<Product>) productRepository.findFavoritesByUserId(arFavorites);
	}									   
	
	
	
	@Transactional(readOnly=true)
	public  List<Product> getByCategoryId(Long categoryId, Long userId) {
		System.out.println(">>>>>userId " + userId);
		if (userId > 0) {
			System.out.println(">>>>>userId > 0: " + userId);
			return productRepository.getByCategroyIdwithFavorites(categoryId, userId);
		}
		else
			return productRepository.getByCategroyId(categoryId);
	}
	
//	@Transactional(readOnly=true)
//	public  List<Product> getFavoritesByUserId(Long id) {
//		return productRepository.findFavoritesByUserId(id);
//	}
	
//	@Transactional(readOnly = true)
//	public List<Product> findFavoritesByUserId(Long id){
//		return (List<Product>)productRepository.findFavoritesByUserId(id);
//	}
	
	@Transactional
	public Product create(ProductDto productDto) {
		
		Product productEntity = new Product();
		
//		productEntity.setId(productDto.getId());
		productEntity.setName(productDto.getName());
		productEntity.setDescription(productDto.getDescription());
		productEntity.setImage(productDto.getImage());
		productEntity.setPrice(productDto.getPrice());
		productEntity.setQuantity(productDto.getQuantity());
		productEntity.setBrand(productDto.getBrand());
		productEntity.setIsOffer(productDto.getIsOffer());
		productEntity.setOfferPrice(productDto.getOfferPrice());
		productEntity.setCategory(productDto.getCategory());

		return productRepository.save(productEntity);
		
		
	}
	
	@Transactional
	public Product update(ProductDto productDto) {
		
		Product productEntity = productRepository.findById(productDto.getId())
				.orElseThrow(()-> new NoSuchElementException("Producto no encontrado con el id: " + productDto.getId()));
		
		productEntity.setId(productDto.getId());
		productEntity.setName(productDto.getName());
		productEntity.setDescription(productDto.getDescription());
		productEntity.setImage(productDto.getImage());
		productEntity.setPrice(productDto.getPrice());
		productEntity.setQuantity(productDto.getQuantity());
		productEntity.setBrand(productDto.getBrand());
		productEntity.setIsOffer(productDto.getIsOffer());
		productEntity.setOfferPrice(productDto.getOfferPrice());
		productEntity.setCategory(productDto.getCategory());

		return productRepository.save(productEntity);
		
		
	}
	
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
	
	
	
}
