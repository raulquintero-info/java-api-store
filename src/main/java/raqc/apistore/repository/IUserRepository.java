package raqc.apistore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import raqc.apistore.dto.UserLoggedDto;
import raqc.apistore.model.User;


public interface IUserRepository extends JpaRepository<User, Long>{
	
	
	@Query(value = "select * from users where username = ?1", nativeQuery = true)
	User findByUserName(String username);

	@Query(value = "select * from users where token = ?1", nativeQuery = true)
	User findUserByToken(String token);

	@Query(value = "update users set human_id = ?1 where id = ?2", nativeQuery = true)
	User updateHumanId(Long humanId, Long userId);

	
	
	@Query(value = "SELECT h.id FROM humans as h LEFT JOIN users as u ON h.id = u.human_id WHERE u.id = '1'", nativeQuery = true)
	User findHumanByUserId(Long id);
	
}
