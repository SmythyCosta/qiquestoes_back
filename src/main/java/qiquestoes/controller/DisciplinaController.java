package qiquestoes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import qiquestoes.persistence.dao.DisciplinaDao;

@RestController
@RequestMapping(value = "/api/disciplina")
@CrossOrigin(origins = "*")
@Api()
public class DisciplinaController extends GenericRestController<DisciplinaDao>{

}
