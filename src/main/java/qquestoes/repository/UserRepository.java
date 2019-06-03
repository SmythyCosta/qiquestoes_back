package qquestoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import qquestoes.model.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	@Transactional(readOnly = true)
	User findByEmail(String email);

	@Transactional(readOnly = true)
	User findByName(String name);
}
