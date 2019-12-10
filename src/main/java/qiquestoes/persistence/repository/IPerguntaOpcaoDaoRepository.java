package qiquestoes.persistence.repository;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.repository.query.Param;

import qiquestoes.persistence.model.PerguntaOpcaoResposta;


@NamedQueries({
	@NamedQuery(name = "PerguntaOpcaoDao.findByPerguntaId", 
			query = "SELECT op FROM PerguntaOpcaoResposta op WHERE op.pergunta.id = :perguntaId") })
public interface IPerguntaOpcaoDaoRepository extends IBaseCustomRepository<PerguntaOpcaoResposta> {

	List<PerguntaOpcaoResposta> findByPerguntaId(@Param("perguntaId") Long perguntaId);

}
