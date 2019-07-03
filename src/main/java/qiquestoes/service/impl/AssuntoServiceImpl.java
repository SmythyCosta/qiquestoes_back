package qiquestoes.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import qiquestoes.model.Assunto;
import qiquestoes.repository.AssuntoRepository;
import qiquestoes.service.AssuntoService;

@Service
public class AssuntoServiceImpl  {
	
	//implements AssuntoService
	
//	private static final Logger log = LoggerFactory.getLogger(AssuntoServiceImpl.class);
//	
//	@Autowired
//	private AssuntoRepository r;
//
//	public Page<Assunto> buscarPorDisciplinaId(Long disciplinaId, PageRequest pageRequest) {
//		log.info("Buscando assunto por  DisciplinaId {}", disciplinaId);
//		return this.r.findByDisciplinaId(disciplinaId, pageRequest);
//	}
//
//	@Override
//	public Optional<Assunto> buscarPorId(Long id) {
//		log.info("Buscando assunto por  Id {}", id);
//		return Optional.ofNullable(this.r.findOne(id));
//	}
//
//	@Override
//	public Assunto persistir(Assunto assunto) {
//		log.info("Persistindo o assunto: {}", assunto);
//		return this.r.save(assunto);
//	}
//
//	@Override
//	public void remover(Long id) {
//		log.info("Removendo o assunto ID {}", id);
//		this.r.delete(id);
//	}

}
