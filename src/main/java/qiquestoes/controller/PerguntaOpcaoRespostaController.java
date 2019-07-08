package qiquestoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import qiquestoes.persistence.dao.PerguntaOpcaoDao;
import qiquestoes.persistence.model.PerguntaOpcaoResposta;

@RestController
@RequestMapping(value = "/api/pergunta-opcao-resposta")
@CrossOrigin(origins = "*")
@Api()
public class PerguntaOpcaoRespostaController extends GenericRestController<PerguntaOpcaoResposta> {
	
	@Autowired
	PerguntaOpcaoDao d;
	
	/**
	 * Retorna a listagem de opcoes de respostas por perguntaId.
	 * 
	 * @param perguntaId
	 * @return List<PerguntaOpcaoResposta>
	 */
	@GetMapping(value = "/pergunta/{perguntaId}")
	public List<PerguntaOpcaoResposta> listarPorPerguntaId(@PathVariable("perguntaId") Long perguntaId) {
				
		return d.findByPerguntaId(perguntaId);
	}
	
}
