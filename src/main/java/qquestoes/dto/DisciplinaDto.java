package qquestoes.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.Optional;

public class DisciplinaDto {
	
	private Optional<Long> id = Optional.empty();
	@NotEmpty(message = "nome não pode ser vazio.")
	private String nome;
	private Long areaFormacaoId;
	
	public DisciplinaDto() {
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

	public Long getAreaFormacaoId() {
		return areaFormacaoId;
	}

	public void setAreaFormacaoId(Long areaFormacaoId) {
		this.areaFormacaoId = areaFormacaoId;
	}
	
	

}
