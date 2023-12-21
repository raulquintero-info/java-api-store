package raqc.apistore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import raqc.apistore.model.Favorite;
import raqc.apistore.model.Product;
import raqc.apistore.model.User;


public interface IFavoriteRepository extends JpaRepository<Favorite, Long>{



	@Query(value = "SELECT * FROM products WHERE category_id = ?1 ORDER BY is_offer ASC", nativeQuery = true)
	List<Product> getByCategroyId(Long categoryId);


	@Query(value = "SELECT * FROM products WHERE is_offer = true ", nativeQuery = true)
	List<Product> findAllOffers();

	
	@Query(value = "SELECT product_id FROM favorites WHERE user_id = ?1 ", nativeQuery = true)
	List<Integer> getFavoritesIdByUserId(Long id);
	
//	@Query(value = "SELECT * FROM products WHERE products.id in :arrayFavorites Order By id DESC", nativeQuery = true)
//	List<Favorite> findFavoritesByUserId1(@Param("arrayFavorites") List<Integer> arrayFavorites);

	@Query(value = "SELECT user_id FROM favorites WHERE product_id = ?1 AND user_id = ?2 ", nativeQuery = true)
	Integer findByProductIdAndUserId(Long id, Long userId);
	
	@Modifying
	@Query(value = "DELETE FROM favorites WHERE product_id = ?1 AND user_id = ?2 ", nativeQuery = true)
	void remove(Long id, Long userId);
	
	
}
