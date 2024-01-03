package raqc.apistore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;

import raqc.apistore.model.Order;
import raqc.apistore.model.OrderStatus;


public interface IOrderStatusRepository extends JpaRepository<OrderStatus, Long>{
	
	
	
	
	
}
