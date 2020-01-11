package qiquestoes.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tbl_pergunta_opcao_resposta")
public class PerguntaOpcaoResposta implements Serializable {

	private static final long serialVersionUID = -8615751844136722809L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Lob
	@Column(name = "descricao", columnDefinition = "TEXT")
	private String descricao;

	@Column(name = "resposta_correta", nullable = false)
	private Boolean respostaCorreta;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Pergunta pergunta;

}
