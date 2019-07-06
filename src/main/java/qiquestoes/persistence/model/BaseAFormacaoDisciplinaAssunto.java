package qiquestoes.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
@SuppressWarnings("serial")
public abstract class BaseAFormacaoDisciplinaAssunto<ID extends Serializable> implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private ID id;
	
	@Column(name = "nome", nullable = false)
	private String nome;

	public BaseAFormacaoDisciplinaAssunto() {
		// TODO Auto-generated constructor stub
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
