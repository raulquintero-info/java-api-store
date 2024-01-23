package raqc.apistore.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import raqc.apistore.dto.UserLoggedDto;
import raqc.apistore.model.User;


public interface IUserRepository extends JpaRepository<User, Long>{
	
	
	@Query(value = "select users.* from users, roles WHERE  roles.id = users.rol_id AND roles.id = 2 ORDER BY users.id ASC", nativeQuery = true)
	List<User> findAllCustomers();
	
	@Query(value = "select users.* from users, roles WHERE  roles.id = users.rol_id AND roles.id = 1 ORDER BY users.id ASC", nativeQuery = true)
	List<User> findAllEmployees();
	
	@Query(value = "select * from users where username = ?1", nativeQuery = true)
	User findByUserName(String username);

	@Query(value = "select * from users where token = ?1", nativeQuery = true)
	User findUserByToken(String token);

	@Query(value = "update users set human_id = ?1 where id = ?2", nativeQuery = true)
	User updateHumanId(Long humanId, Long userId);

	
	
//	@Query(value = "SELECT * FROM users,humans WHERE humans.id=users.human_id AND users.id = '1'", nativeQuery = true)
	//Error - NonUniqueDiscoveredSqlAliasException: Encountered a duplicated sql alias [id] during auto-discovery of a native-sql query
	
	@Query(value = "SELECT * FROM users WHERE  users.id = :id", nativeQuery = true)
	User findByUserId(@PathVariable("id") Long id);
	
	@Query(value = "SELECT count(id) FROM users WHERE  rol_id=2", nativeQuery = true)
	Long countByCustomers();
	
}
