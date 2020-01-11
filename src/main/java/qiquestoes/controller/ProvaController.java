package qiquestoes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import qiquestoes.persistence.model.Assunto;
import qiquestoes.persistence.model.Concurso;
import qiquestoes.persistence.model.Prova;

@RestController
@RequestMapping(value = "/api/prova")
@CrossOrigin(origins = "*")
@Api()
public class ProvaController extends GenericRestController<Prova> {

}