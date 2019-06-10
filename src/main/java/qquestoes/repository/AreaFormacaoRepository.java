package qquestoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import qquestoes.model.AreaFormacao;
import qquestoes.model.User;

public interface AreaFormacaoRepository extends JpaRepository<AreaFormacao, Long>{
	
	@Transactional(readOnly = true)
	AreaFormacao findById(Long id);

}
