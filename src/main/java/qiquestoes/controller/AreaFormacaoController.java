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
import io.swagger.annotations.ApiOperation;
import qiquestoes.persistence.model.AreaFormacao;
import qiquestoes.persistence.repository.IAreaFormacaoRepository;

@RestController
@RequestMapping(value="/api/area-formacao")
@CrossOrigin(origins = "*")
@Api(value="API REST AreaFormacao")
public class AreaFormacaoController {

	@Autowired
	private IAreaFormacaoRepository r;
	
	@ApiOperation(value="Listar todos")
	@GetMapping()
	public List<AreaFormacao> listarTodos() {
		return r.findAll();
	}
	
	@ApiOperation(value="Listar Por ID")
	@GetMapping(value = { "/{id}" })
	public Optional<AreaFormacao> encontrarPorId(@PathVariable long id) {
		return r.findById(id);
	}

	@ApiOperation(value="Criar novo")
	@PostMapping()
	public AreaFormacao criarNovo(@RequestBody AreaFormacao obj) {
		return r.save(obj);
	}
	
	@ApiOperation(value="Alterar Por ID")
	@PutMapping(value = "/{id}")
	public AreaFormacao atualiza(@RequestBody @Valid AreaFormacao obj) {
		return r.save(obj);
	}
	
	@ApiOperation(value="Deletar Por ID")
	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable long id) {
		r.deleteById(id);
	}

}
