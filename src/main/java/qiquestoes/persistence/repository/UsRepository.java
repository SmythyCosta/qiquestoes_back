package qiquestoes.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qiquestoes.persistence.model.User;

//@Repository
public interface UsRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

	User findByName(String name);
}
