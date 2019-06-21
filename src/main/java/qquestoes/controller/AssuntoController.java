package qquestoes.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qquestoes.model.Assunto;
import qquestoes.repository.AssuntoRepository;

@RestController
@RequestMapping(value = "/api/assunto")
@CrossOrigin(origins = "*")
public class AssuntoController {

	@Autowired
	private AssuntoRepository r;

	@GetMapping
	public List findAll() {
		return r.findAll();
	}
	

	@GetMapping(value = { "/{id}" })
	public Assunto findById(@PathVariable long id) {
		return r.findById(id);
	}

	@PostMapping
	public Assunto create(@RequestBody Assunto obj) {
		return r.save(obj);
	}
	
	@PutMapping(value = "/{id}")
	public Assunto atualiza(@RequestBody @Valid Assunto obj) {
		return r.save(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable long id) {
		r.delete(id);
	}

	
}