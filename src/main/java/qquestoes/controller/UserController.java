package qquestoes.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import qquestoes.dto.UserDTO;
import qquestoes.model.User;
import qquestoes.response.Response;
import qquestoes.service.UserService;

@RestController
@RequestMapping(value="/api/users")
@CrossOrigin(origins = "*")
public class UserController {	
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserService userService;
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	
	
	/**
	 * Retorna a listagem de user.
	 * 
	 * @param funcionarioId
	 * @return ResponseEntity<Response<LancamentoDto>>
	 */
	@GetMapping()
	public ResponseEntity<Response<Page<UserDTO>>> listAll(
			@RequestParam(value = "pag", defaultValue = "0") int pag,
			@RequestParam(value = "ord", defaultValue = "id") String ord,
			@RequestParam(value = "dir", defaultValue = "DESC") String dir
		) 
	{
		
		log.info("Listando todos os users: {}, página: {}", pag);
		Response<Page<UserDTO>> response = new Response<Page<UserDTO>>();

		PageRequest pageRequest = new PageRequest(pag, this.qtdPorPagina, Direction.valueOf(dir), ord);
		Page<User> users = this.userService.listarTodos(pageRequest);
		Page<UserDTO> userDto = users.map(user -> this.converterUserOfDTO(user));

		response.setData(userDto);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Retorna um user por ID.
	 * 
	 * @param id
	 * @return ResponseEntity<Response<UserDTO>>
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<UserDTO>> listarPorId(@PathVariable("id") Long id) {
		log.info("Buscando lançamento por ID: {}", id);
		Response<UserDTO> response = new Response<UserDTO>();
		Optional<User> user = this.userService.buscarPorId(id);

		if (!user.isPresent()) {
			log.info("User não encontrado para o ID: {}", id);
			response.getErrors().add("User não encontrado para o id " + id);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(this.converterUserOfDTO(user.get()));
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Converte uma entidade User para seu respectivo DTO.
	 * 
	 * @param lancamento
	 * @return LancamentoDto
	 */
	private UserDTO converterUserOfDTO(User user) {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(Optional.of(user.getId()));
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		userDTO.setRole_user(user.getRole_user().toString());

		return userDTO;
	}
	
	
		
	
}
