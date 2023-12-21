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




@Service
public class FavoriteService {

	@Autowired
	private IFavoriteRepository favoriteRepository;
	
	
	@Transactional(readOnly=true)
	public  Favorite findById(Long id) {
		System.out.println("error en service::findById()");
		return favoriteRepository.findById(id).get();
	}
	
	@Transactional(readOnly=true)
	public  Integer findByProductIdAndUserId(Long id, Long userId) {
		System.out.println("error en service::findByProductIdAndUserId()");
		return (Integer) favoriteRepository.findByProductIdAndUserId(id, userId);
	}
//	@Transactional(readOnly = true)
//	public List<Favorite> findFavoritesByUserId(List<Integer> arrayFavorites){
//		return (List<Favorite>)favoriteRepository.findFavoritesByUserId1(arrayFavorites);
//	}
	
	
	@Transactional(readOnly = true)
	public List<Integer> getFavoritesIdByUserId(Long id){
		return (List<Integer>)favoriteRepository.getFavoritesIdByUserId(id);
	}
	
	
	
	@Transactional
//	@Modifying(clearAutomatically = true)
	public  Favorite addFavorite(Favorite  favoriteProduct) {
		System.out.println(" >>>>>>>>>>>> addFavorite p: " + favoriteProduct.getProductId() + " u: " + favoriteProduct.getUserId() );
		return favoriteRepository.save(favoriteProduct);
	}
	
	@Transactional
	public  void removeFavorite(Favorite  favoriteProduct) {
		Favorite temp = null;
		System.out.println(" >>>>>>>>>>>> removeFavorite p: " + favoriteProduct.getProductId() + " u: " + favoriteProduct.getUserId());
		favoriteRepository.remove(favoriteProduct.getProductId(),favoriteProduct.getUserId());

	}
	
	
	
	
//	@Transactional
//	public Product create(ProductDto productDto) {
//		
//		Product productEntity = new Product();
//		
//		productEntity.setName(productDto.getName());
//		productEntity.setDescription(productDto.getDescription());
//		productEntity.setImage(productDto.getImage());
//		productEntity.setPrice(productDto.getPrice());
//		productEntity.setQuantity(productDto.getQuantity());
//		productEntity.setBrand(productDto.getBrand());
//		productEntity.setIsOffer(productDto.getIsOffer());
//		productEntity.setOfferPrice(productDto.getOfferPrice());
//		productEntity.setCategory(productDto.getCategory());
//
//		return productRepository.save(productEntity);
//		
//		
//	}
	
	
	
	public void delete(Long id) {
		favoriteRepository.deleteById(id);
	}
	
	
	
}
