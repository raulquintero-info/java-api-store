package raqc.apistore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import raqc.apistore.dto.UserLoggedDto;
import raqc.apistore.model.User;


public interface IUserRepository extends JpaRepository<User, Long>{
	
	
	@Query(value = "select * from users where username = ?1", nativeQuery = true)
	User findByUserName(String username);

	@Query(value = "select * from users where token = ?1", nativeQuery = true)
	User findUserByToken(String token);

	@Query(value = "update users set human_id = ?1 where id = ?2", nativeQuery = true)
	User updateHumanId(Long humanId, Long userId);

	
	
//	@Query(value = "SELECT * FROM users,humans WHERE humans.id=users.human_id AND users.id = '1'", nativeQuery = true)
	//Error - NonUniqueDiscoveredSqlAliasException: Encountered a duplicated sql alias [id] during auto-discovery of a native-sql query
	
	@Query(value = "SELECT * FROM users WHERE  users.id = :id", nativeQuery = true)
	User findHumanByUserId(@PathVariable("id") Long id);
	
}
