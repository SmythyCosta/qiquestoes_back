package qiquestoes.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import qiquestoes.model.User;

public interface UserService {
	
	/**
	 * Retorna uma lista paginada de User.
	 * 
	 * @param pageRequest
	 * @return Page<user>
	 */
	Page<User> listarTodos(PageRequest pageRequest);

	/**
	 * Retorna um User por ID.
	 * 
	 * @param id
	 * @return Optional<user>
	 */
	Optional<User> buscarPorId(Long id);
	
	/**
	 * Retorna um User por Email.
	 * 
	 * @param id
	 * @return Optional<user>
	 */
	Optional<User> buscarPorEmail(String email);
	
	/**
	 * Retorna um User por Name.
	 * 
	 * @param id
	 * @return Optional<user>
	 */
	Optional<User> buscarPorNome(String name);
	
	/**
	 * Persiste um User na base de dados.
	 * 
	 * @param user
	 * @return user
	 */
	User persistir(User user);
	
	/**
	 * Remove um User da base de dados.
	 * 
	 * @param id
	 */
	void remover(Long id);
}
