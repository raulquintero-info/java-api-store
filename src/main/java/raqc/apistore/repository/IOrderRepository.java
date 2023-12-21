package raqc.apistore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;

import raqc.apistore.model.Order;


public interface IOrderRepository extends JpaRepository<Order, Long>{
}
