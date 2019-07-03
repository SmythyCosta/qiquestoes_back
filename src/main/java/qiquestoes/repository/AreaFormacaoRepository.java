package qiquestoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import qiquestoes.model.AreaFormacao;
import qiquestoes.model.User;

public interface AreaFormacaoRepository extends JpaRepository<AreaFormacao, Long>{
	
//	@Transactional(readOnly = true)
//	AreaFormacao findById(Long id);

}
