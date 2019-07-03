package qiquestoes.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import qiquestoes.model.User;
import qiquestoes.repository.UserRepository;
import qiquestoes.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Page<User> listarTodos(PageRequest pageRequest) {
		log.info("Listando users {}");
		return this.userRepository.findAll(pageRequest);
	}

	@Override
	public Optional<User> buscarPorId(Long id) {
		log.info("Buscando um user pelo ID {}", id);
		return Optional.ofNullable(this.userRepository.findOne(id));
	}

	@Override
	public User persistir(User user) {
		log.info("Persistindo o user: {}", user);
		return this.userRepository.save(user);
	}

	@Override
	public void remover(Long id) {
		log.info("Removendo o User ID {}", id);
		this.userRepository.delete(id);
	}

	@Override
	public Optional<User> buscarPorEmail(String email) {
		log.info("Buscando um User por o Email {}", email);
		return Optional.ofNullable(userRepository.findByEmail(email));
	}

	@Override
	public Optional<User> buscarPorNome(String name) {
		log.info("Buscando um User por o Name {}", name);
		return Optional.ofNullable(userRepository.findByName(name));
	}

}
