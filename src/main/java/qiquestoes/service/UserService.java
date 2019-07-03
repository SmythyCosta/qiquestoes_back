package qiquestoes.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import qiquestoes.model.User;

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
	 * Retorna um user por Email.
	 * 
	 * @param id
	 * @return Optional<user>
	 */
	Optional<User> buscarPorEmail(String email);
	
	/**
	 * Retorna um user por Name.
	 * 
	 * @param id
	 * @return Optional<user>
	 */
	Optional<User> buscarPorNome(String name);
	
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
