package qiquestoes.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import qiquestoes.persistence.model.AreaFormacao;
import qiquestoes.persistence.repository.AreaFormacaoRepository;

@RestController
@RequestMapping(value="/api/area-formacao")
@CrossOrigin(origins = "*")
@Api()
public class AreaFormacaoController {

	@Autowired
	private AreaFormacaoRepository r;

	@GetMapping()
	public List<AreaFormacao> listarTodos() {
		return r.findAll();
	}
	
	@GetMapping(value = { "/{id}" })
	public Optional<AreaFormacao> encontrarPorId(@PathVariable long id) {
		return r.findById(id);
	}

	@PostMapping()
	public AreaFormacao criarNovo(@RequestBody AreaFormacao obj) {
		return r.save(obj);
	}
	
	@PutMapping(value = "/{id}")
	public AreaFormacao atualiza(@RequestBody @Valid AreaFormacao obj) {
		return r.save(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable long id) {
		r.deleteById(id);
	}

}
