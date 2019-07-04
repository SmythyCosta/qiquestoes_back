package qiquestoes.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import qiquestoes.dto.AssuntoDto;
import qiquestoes.persistence.model.Assunto;
import qiquestoes.repository.AssuntoRepository;
import qiquestoes.response.Response;
import qiquestoes.service.AssuntoService;

@RestController
@RequestMapping(value = "/api/assunto")
@CrossOrigin(origins = "*")
public class AssuntoController {
	
	private static final Logger log = LoggerFactory.getLogger(AssuntoController.class);

	@Autowired
	private AssuntoRepository r;
	@Autowired
	private AssuntoService s;
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	/**
	 * Retorna a listagem de Assunto por disciplina.
	 * 
	 * @param disciplinaId
	 * @return ResponseEntity<Response<AssuntoDto>>
	 */
	@GetMapping(value = "/disciplina/{disciplinaId}")
	public ResponseEntity<Response<Page<AssuntoDto>>> listarPorDisciplinaId(
			@PathVariable("disciplinaId") Long disciplinaId,
			@RequestParam(value = "pag", defaultValue = "0") int pag,
			@RequestParam(value = "ord", defaultValue = "id") String ord,
			@RequestParam(value = "dir", defaultValue = "DESC") String dir) {
		
		log.info("Listando Assunto por disciplinaId: {}, página: {}", disciplinaId, pag);
		
		Response<Page<AssuntoDto>> response = new Response<Page<AssuntoDto>>();

		PageRequest pageRequest = new PageRequest(pag, this.qtdPorPagina, Direction.valueOf(dir), ord);
		Page<Assunto> assuntos = this.s.buscarPorDisciplinaId(disciplinaId, pageRequest);
		Page<AssuntoDto> assuntoDto = assuntos.map(assunto -> this.converterAssuntoDto(assunto));

		response.setData(assuntoDto);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Converte uma entidade Assunto para seu respectivo DTO.
	 * 
	 * @param assunto
	 * @return assuntoDto
	 */
	private AssuntoDto converterAssuntoDto(Assunto assunto) {
		AssuntoDto assuntoDto = new AssuntoDto();
		assuntoDto.setId(Optional.of(assunto.getId()));
		assuntoDto.setNome(assunto.getNome());
		assuntoDto.setDisciplinaId(assunto.getDisciplina().getId());

		return assuntoDto;
	}
	
}
