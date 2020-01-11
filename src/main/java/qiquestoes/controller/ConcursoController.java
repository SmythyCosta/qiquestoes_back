package qiquestoes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import qiquestoes.persistence.model.Assunto;
import qiquestoes.persistence.model.Concurso;

@RestController
@RequestMapping(value = "/api/concurso")
@CrossOrigin(origins = "*")
@Api()
public class ConcursoController extends GenericRestController<Concurso> {

}