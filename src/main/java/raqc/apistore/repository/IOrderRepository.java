package raqc.apistore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import raqc.apistore.model.Address;
import raqc.apistore.model.Order;


public interface IOrderRepository extends JpaRepository<Order, Long>{
	
	@Query(value = "SELECT * FROM orders WHERE user_id = ?1 ORDER BY id DESC", nativeQuery = true)
	List<Order> findAllByUserId(Long userId);

	
	
	
	
}
