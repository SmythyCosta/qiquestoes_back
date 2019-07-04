package qiquestoes.repository;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import qiquestoes.persistence.model.Assunto;


@Transactional(readOnly = true)
@NamedQueries({
		@NamedQuery(name = "AssuntoRepository.findByDisciplinaId", 
				query = "SELECT assu FROM assunto assu WHERE assu.disciplina.id = :disciplinaId") })
public interface AssuntoRepository extends JpaRepository<Assunto, Long>{
	
	List<Assunto> findByDisciplinaId(@Param("disciplinaId") Long disciplinaId);
	Page<Assunto> findByDisciplinaId(@Param("disciplinaId") Long disciplinaId, Pageable pageable);

}
