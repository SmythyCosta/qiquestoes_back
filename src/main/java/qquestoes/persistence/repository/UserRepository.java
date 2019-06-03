package qquestoes.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import qquestoes.persistence.models.User;


public interface UserRepository extends JpaRepository<User, Long>{

	Object findById(long id);

}
