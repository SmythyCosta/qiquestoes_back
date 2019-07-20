package qiquestoes.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qiquestoes.persistence.enums.RoleNameEnum;
import qiquestoes.persistence.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByName(RoleNameEnum roleName);
}
