package qiquestoes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import qiquestoes.persistence.model.Pergunta;

@RestController
@RequestMapping(value = "/api/pergunta")
@CrossOrigin(origins = "*")
@Api()
public class PerguntaController extends GenericRestController<Pergunta> {

}
