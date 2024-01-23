package raqc.apistore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import raqc.apistore.dto.ProductDto;
import raqc.apistore.model.Favorite;
import raqc.apistore.model.Product;
import raqc.apistore.model.User;


public interface IProductRepository extends JpaRepository<Product, Long>{


	@Query(value = "SELECT * FROM products WHERE category_id = :categoryId ORDER BY is_offer ASC", nativeQuery = true)
	public List<Product> findAllProducts(@Param("categoryId") Integer categoryId);
	
	@Query(value = "SELECT * FROM products WHERE category_id = ?1 ORDER BY is_offer ASC", nativeQuery = true)
	List<Product> getByCategroyId(Long categoryId);
	
	//query to retrieve favorites products by userId
	@Query(value = "SELECT *, EXISTS(SELECT user_id FROM favorites where user_id = ?2 and product_id=products.id) as isFavorite "
			+ "FROM products "
			+ "WHERE category_id = ?1 ORDER BY is_offer ASC", nativeQuery = true)
	List<Product> getByCategroyIdwithFavorites(Long categoryId, Long userId);

	@Query(value = "SELECT * FROM products WHERE is_offer = true ", nativeQuery = true)
	List<Product> findAllOffers();

	
//	@Query(value = "SELECT * FROM favorites WHERE user_id in (?1) ", nativeQuery = true)
//	List<Product> findFavoritesIdByUserId(Long categoryId);

	//Query to retrieve one product with favorite status by userId
	@Query(value = "SELECT *, (SELECT user_id FROM favorites WHERE user_id = ?2 AND product_id=products.id) AS isFavorite "
			+ "FROM products "
			+ "WHERE products.id= ?1  ", nativeQuery = true)
	Product findFavoriteByUserId(Long productId, Long userId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO favorites(product_id, user_id) values(17, 1) ", nativeQuery = true)
	List<Product> addFavorite(Long productId, Long userId);

	@Query(value = "SELECT * FROM products WHERE products.id in :arrayFavorites Order By id DESC", nativeQuery = true)
	List<Product> findFavoritesByUserId(@Param("arrayFavorites") List<Integer> arrayFavorites);

	

}
