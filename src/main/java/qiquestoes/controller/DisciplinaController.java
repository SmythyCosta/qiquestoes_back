package qiquestoes.controller;

import java.text.ParseException;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.lang3.EnumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import qiquestoes.dto.DisciplinaDto;
import qiquestoes.persistence.model.Disciplina;
import qiquestoes.repository.DisciplinaRepository;
import qiquestoes.response.Response;
import qiquestoes.service.DisciplinaService;

@RestController
@RequestMapping(value = "/api/disciplina")
@CrossOrigin(origins = "*")
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository r;
	@Autowired
	private DisciplinaService s;
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	/**
	 * Retorna a listagem de disciplina por areaFormacao.
	 * 
	 * @param areaFormacaoId
	 * @return ResponseEntity<Response<LancamentoDto>>
	 */
	@GetMapping(value = "/area-formacao/{areaFormacaoId}")
	public ResponseEntity<Response<Page<DisciplinaDto>>> listarPorAreaFormacaoId(
			@PathVariable("areaFormacaoId") Long areaFormacaoId,
			@RequestParam(value = "pag", defaultValue = "0") int pag,
			@RequestParam(value = "ord", defaultValue = "id") String ord,
			@RequestParam(value = "dir", defaultValue = "DESC") String dir) {
		Response<Page<DisciplinaDto>> response = new Response<Page<DisciplinaDto>>();

		PageRequest pageRequest = new PageRequest(pag, this.qtdPorPagina, Direction.valueOf(dir), ord);
		Page<Disciplina> disciplinas = this.s.buscarPorAreaFormacaoId(areaFormacaoId, pageRequest);
		Page<DisciplinaDto> disciplinaDto = disciplinas.map(disciplina -> this.converterDisciplinaDto(disciplina));

		response.setData(disciplinaDto);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Converte uma entidade disciplina para seu respectivo DTO.
	 * 
	 * @param disciplina
	 * @return disciplinaDto
	 */
	private DisciplinaDto converterDisciplinaDto(Disciplina disciplina) {
		DisciplinaDto disciplinaDto = new DisciplinaDto();
		disciplinaDto.setId(Optional.of(disciplina.getId()));
		disciplinaDto.setNome(disciplina.getNome());
		disciplinaDto.setAreaFormacaoId(disciplina.getAreaFormacao().getId());

		return disciplinaDto;
	}
	
}
