package raqc.apistore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;

import raqc.apistore.model.Customer;


public interface ICustomerRepository extends JpaRepository<Customer, Long>{
}
