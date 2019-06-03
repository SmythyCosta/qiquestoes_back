package qquestoes.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import qquestoes.model.User;

public interface UserService {
	
	/**
	 * Retorna uma lista paginada de user.
	 * 
	 * @param pageRequest
	 * @return Page<user>
	 */
	Page<User> listarTodos(PageRequest pageRequest);

	/**
	 * Retorna um user por ID.
	 * 
	 * @param id
	 * @return Optional<user>
	 */
	Optional<User> buscarPorId(Long id);
	
	/**
	 * Persiste um user na base de dados.
	 * 
	 * @param user
	 * @return user
	 */
	User persistir(User user);
	
	/**
	 * Remove um lançamento da base de dados.
	 * 
	 * @param id
	 */
	void remover(Long id);
}
