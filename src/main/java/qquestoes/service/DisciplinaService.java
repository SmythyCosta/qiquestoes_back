package qquestoes.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import qquestoes.model.Disciplina;


public interface DisciplinaService {
	

	Page<Disciplina> buscarPorAreaFormacaoId(Long areaFormacaoId, PageRequest pageRequest);
	Optional<Disciplina> buscarPorId(Long id);
	Disciplina persistir(Disciplina disciplina);
	void remover(Long id);

}
