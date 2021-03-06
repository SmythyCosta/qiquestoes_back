package qiquestoes.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qiquestoes.persistence.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User findById(long id);
}
