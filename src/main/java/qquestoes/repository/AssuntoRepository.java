package qquestoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import qquestoes.model.Assunto;

public interface AssuntoRepository extends JpaRepository<Assunto, Long>{
	
	@Transactional(readOnly = true)
	Assunto findById(Long id);

}
