package qquestoes.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import qquestoes.model.Disciplina;
import qquestoes.repository.DisciplinaRepository;
import qquestoes.service.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {
	
	@Autowired
	private DisciplinaRepository r;

	public Page<Disciplina> buscarPorAreaFormacaoId(Long areaFormacaoId, PageRequest pageRequest) {
		return this.r.findByAreaFormacaoId(areaFormacaoId, pageRequest);
	}

	@Override
	public Optional<Disciplina> buscarPorId(Long id) {
		return Optional.ofNullable(this.r.findOne(id));
	}

	@Override
	public Disciplina persistir(Disciplina disciplina) {
		return this.r.save(disciplina);
	}

	@Override
	public void remover(Long id) {
		this.r.delete(id);
	}

}
