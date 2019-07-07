package qiquestoes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import qiquestoes.persistence.model.Assunto;

@RestController
@RequestMapping(value = "/api/assunto")
@CrossOrigin(origins = "*")
@Api()
public class AssuntoController extends GenericRestController<Assunto> {

}