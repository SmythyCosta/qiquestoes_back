package qquestoes.repository;


import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import qquestoes.model.Disciplina;


@Transactional(readOnly = true)
@NamedQueries({
		@NamedQuery(name = "DisciplinaRepository.findByAreaFormacaoId", 
				query = "SELECT disc FROM disciplina disc WHERE disc.areaFormacao.id = :areaFormacaoId") })
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
	
	List<Disciplina> findByAreaFormacaoId(@Param("areaFormacaoId") Long areaFormacaoId);
	Page<Disciplina> findByAreaFormacaoId(@Param("areaFormacaoId") Long areaFormacaoId, Pageable pageable);

}
