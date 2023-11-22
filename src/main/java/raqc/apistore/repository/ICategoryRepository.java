package raqc.apistore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import raqc.apistore.model.Category;
import raqc.apistore.model.Product;


public interface ICategoryRepository extends JpaRepository<Category, Long>{
	
	
	@Query(value = "update categories set quantity= quantity + 1 where id = ?1", nativeQuery = true)
	void plusOneQuantityProduct(Long CategroyId);

	@Query(value = "update categories set quantity= quantity - 1 where id = ?1", nativeQuery = true)
	void minusOneQuantityProduct(Long categoryId);

	@Query(value = "SELECT * FROM CATEGORIES WHERE is_enabled=true", nativeQuery = true)
	List<Category> getCategoriesEnabled();
	
}
