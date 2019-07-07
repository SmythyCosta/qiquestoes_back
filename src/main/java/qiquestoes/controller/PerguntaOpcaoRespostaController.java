package qiquestoes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import qiquestoes.persistence.model.PerguntaOpcaoResposta;

@RestController
@RequestMapping(value = "/api/pergunta-opcao-resposta")
@CrossOrigin(origins = "*")
@Api()
public class PerguntaOpcaoRespostaController extends GenericRestController<PerguntaOpcaoResposta> {

}
