package qquestoes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_pergunta_opcao", uniqueConstraints = { @UniqueConstraint(columnNames = { "descricao" }) })
public class PerguntaOpcao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8615751844136722809L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "descricao", nullable = false)
	private String descricao;
	@Column(name = "resposta_correta", nullable = false)
	private Boolean respostaCorreta;
	@ManyToOne(fetch = FetchType.EAGER)
	private Pergunta pergunta;

	public PerguntaOpcao() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getRespostaCorreta() {
		return respostaCorreta;
	}

	public void setRespostaCorreta(Boolean respostaCorreta) {
		this.respostaCorreta = respostaCorreta;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

}
