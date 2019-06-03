package qquestoes.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import qquestoes.model.User;
import qquestoes.repository.UserRepository;
import qquestoes.service.UserService;

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
		log.info("Removendo o lançamento ID {}", id);
		this.userRepository.delete(id);
	}

}
