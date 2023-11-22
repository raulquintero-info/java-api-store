package raqc.apistore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import raqc.apistore.model.Product;
import raqc.apistore.model.User;


public interface IProductRepository extends JpaRepository<Product, Long>{



	@Query(value = "SELECT * FROM products WHERE category_id = ?1 ORDER BY is_offer ASC", nativeQuery = true)
	List<Product> getByCategroyId(Long categoryId);


	@Query(value = "SELECT * FROM products WHERE is_offer = true ", nativeQuery = true)
	List<Product> findAllOffers();

	


}
