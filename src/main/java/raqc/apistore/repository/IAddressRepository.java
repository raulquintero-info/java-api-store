package raqc.apistore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import raqc.apistore.model.Address;


public interface IAddressRepository extends JpaRepository<Address, Long>{
	
	@Query(value = "SELECT * From addresses where user_id = ?1", nativeQuery = true)
	List<Address> findByUserId(Long userId);

	
	
	
	
	
}
