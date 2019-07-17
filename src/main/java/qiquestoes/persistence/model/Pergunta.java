package qiquestoes.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "tbl_pergunta")
public class Pergunta implements Serializable {

	private static final long serialVersionUID = -7634247679759632411L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Lob
	@Column(name = "descricao", columnDefinition = "TEXT")
	private String descricao;

	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;

	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;

	@Column(name = "ativo", nullable = false)
	private Boolean ativo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Assunto assunto;

	@OneToMany(mappedBy = "pergunta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	//@JsonManagedReference
	private List<PerguntaOpcaoResposta> perguntaOpcaoResposta;

}
