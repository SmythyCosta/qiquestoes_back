package qiquestoes.repository;

import org.springframework.data.repository.CrudRepository;

import qiquestoes.model.Pergunta;

public interface PerguntaRepository  extends CrudRepository<Pergunta, Long>{
	
	Pergunta findById(long id);

}
