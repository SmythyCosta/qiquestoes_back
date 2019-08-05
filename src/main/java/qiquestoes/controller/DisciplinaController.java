package qiquestoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import qiquestoes.persistence.dao.BaseDao;
import qiquestoes.persistence.dao.DisciplinaDao;
import qiquestoes.persistence.model.Disciplina;

@RestController
@RequestMapping(value = "/api/disciplina")
@CrossOrigin(origins = "*")
@Api()
public class DisciplinaController extends GenericRestController<Disciplina> {

}
