package qquestoes.repository;

import org.springframework.data.repository.CrudRepository;

import qquestoes.model.Pergunta;

public interface PerguntaRepository  extends CrudRepository<Pergunta, Long>{
	
	Pergunta findById(long id);

}
