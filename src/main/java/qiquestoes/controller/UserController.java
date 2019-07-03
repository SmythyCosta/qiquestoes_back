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

import qiquestoes.dto.UserDTO;
import qiquestoes.enums.RoleEnum;
import qiquestoes.model.User;
import qiquestoes.response.Response;
import qiquestoes.service.UserService;

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
	public ResponseEntity<Response<Page<UserDTO>>> listAll(@RequestParam(value = "pag", defaultValue = "0") int pag,
															@RequestParam(value = "ord", defaultValue = "id") String ord,
															@RequestParam(value = "dir", defaultValue = "DESC") String dir) {
		
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
	 * Cadastrar um user.
	 * 
	 * @param userDTO
	 * @param result
	 * @return ResponseEntity<Response<UserDTO>>
	 * @throws ParseException
	 */
	@PostMapping()
	public ResponseEntity<Response<UserDTO>> cadastrar(@Valid @RequestBody UserDTO userDTO,
														BindingResult result) throws ParseException {
		
		log.info("Cadastrando User: {}", userDTO.toString());
		Response<UserDTO> response = new Response<UserDTO>();

		validarDadosExistentes(userDTO, result);
		User user = this.converterDtoOfUser(userDTO, result);

		if (result.hasErrors()) {
			log.error("Erro validando dados de cadastro User: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		this.userService.persistir(user);
		response.setData(this.converterUserOfDTO(user));
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Atualiza os dados de um user.
	 * 
	 * @param id
	 * @param userDto
	 * @return ResponseEntity<Response<User>>
	 * @throws ParseException 
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Response<UserDTO>> atualizar(@PathVariable("id") Long id,
														@Valid @RequestBody UserDTO userDTO, 
														BindingResult result) throws ParseException {
		
		log.info("Atualizando user: {}", userDTO.toString());
		Response<UserDTO> response = new Response<UserDTO>();
		userDTO.setId(Optional.of(id));
		User user = this.converterDtoOfUser(userDTO, result);

		if (result.hasErrors()) {
			log.error("Erro validando user: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		user = this.userService.persistir(user);
		response.setData(this.converterUserOfDTO(user));
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Remove um user.
	 * 
	 * @param id
	 * @return ResponseEntity<Response<user>>
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response<String>> remover(@PathVariable("id") Long id) {
		
		log.info("Removendo user: {}", id);
		Response<String> response = new Response<String>();
		Optional<User> user = this.userService.buscarPorId(id);

		if (!user.isPresent()) {
			log.info("Erro ao remover user ID: {} ser inválido.", id);
			response.getErrors().add("Erro ao remover user. Registro não encontrado para o id " + id);
			return ResponseEntity.badRequest().body(response);
		}

		this.userService.remover(id);
		return ResponseEntity.ok(new Response<String>());
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
	
	/**
	 * Converte um DTO para uma entidade User.
	 * 
	 * @param userDto
	 * @param result
	 * @return User
	 * @throws ParseException 
	 */
	private User converterDtoOfUser(UserDTO userDTO, BindingResult result) throws ParseException {
		
		User user = new User();

		if (userDTO.getId().isPresent()) {
			Optional<User> u = this.userService.buscarPorId(userDTO.getId().get());
			if (u.isPresent()) {
				user = u.get();
			} else {
				result.addError(new ObjectError("user", "user não encontrado."));
			}
		} else {
			user.setId(null);
		}
		
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());


		if (EnumUtils.isValidEnum(RoleEnum.class, userDTO.getRole_user())) {
			user.setRole_user(RoleEnum.valueOf(userDTO.getRole_user()));
		} else {
			result.addError(new ObjectError("Role_user", "Role_user inválido."));
		}

		return user;
	}
	
	/**
	 * Verifica se os dados de user está cadastrado e se o mesmo não existe na base de dados.
	 * 
	 * @param cadastroPFDTO
	 * @param result
	 */
	private void validarDadosExistentes(UserDTO userDTO, BindingResult result) {
		
		this.userService.buscarPorNome(userDTO.getName())
			.ifPresent(us -> result.addError(new ObjectError("user", "Name já existente.")));
		
		this.userService.buscarPorEmail(userDTO.getEmail())
			.ifPresent(us -> result.addError(new ObjectError("user", "Email já existente.")));
	
	}
	
}
