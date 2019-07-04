package qiquestoes.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import qiquestoes.persistence.model.AreaFormacao;
import qiquestoes.persistence.model.User;

public interface AreaFormacaoRepository extends JpaRepository<AreaFormacao, Long>{
	
//	@Transactional(readOnly = true)
//	AreaFormacao findById(Long id);

}
