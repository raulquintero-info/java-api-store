package raqc.apistore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;

import raqc.apistore.model.Human;


public interface IHumanRepository extends JpaRepository<Human, Long>{
	
	
	
	@Query(value = "SELECT h.id as hid, u.id as uid  FROM humans as h LEFT JOIN users as u ON h.id = u.human_id WHERE u.id = 1", nativeQuery = true)
	Human findHumanByUserId(Long id);
	
	
}
