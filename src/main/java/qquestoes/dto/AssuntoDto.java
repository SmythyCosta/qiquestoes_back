package qquestoes.dto;

import java.util.Optional;

import org.hibernate.validator.constraints.NotEmpty;

public class AssuntoDto {

	private Optional<Long> id = Optional.empty();
	@NotEmpty(message = "nome não pode ser vazio.")
	private String nome;
	private Long disciplinaId;

	public AssuntoDto() {
		// TODO Auto-generated constructor stub
	}

	public Optional<Long> getId() {
		return id;
	}

	public void setId(Optional<Long> id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getDisciplinaId() {
		return disciplinaId;
	}

	public void setDisciplinaId(Long disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

}
