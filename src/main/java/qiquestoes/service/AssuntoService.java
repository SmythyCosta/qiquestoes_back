package qiquestoes.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import qiquestoes.model.Assunto;

public interface AssuntoService {

	Page<Assunto> buscarPorDisciplinaId(Long disciplinaId, PageRequest pageRequest);
	Optional<Assunto> buscarPorId(Long id);
	Assunto persistir(Assunto assunto);
	void remover(Long id);

}