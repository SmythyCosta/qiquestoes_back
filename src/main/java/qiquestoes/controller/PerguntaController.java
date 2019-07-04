package qiquestoes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qiquestoes.persistence.model.Pergunta;
import qiquestoes.persistence.repository.PerguntaRepository;

@RestController
@RequestMapping(value = "/api/pergunta")
@CrossOrigin(origins = "*")
public class PerguntaController {
	
	@Autowired
	PerguntaRepository r;

}
