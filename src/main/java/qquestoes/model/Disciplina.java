package qquestoes.model;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_disciplina", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class Disciplina implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6426311325596834090L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@ManyToOne
	@JoinColumn
	private AreaFormacao areaFormacao;
	
	@OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL)
	private Set<Assunto> assunto;
	
	

	public Disciplina(String nome, String descricao, AreaFormacao areaFormacao, Assunto assunto) {
		this.nome = nome;
		this.descricao = descricao;
		this.areaFormacao = areaFormacao;
		this.assunto = Stream.of(assunto).collect(Collectors.toSet());
		this.assunto.forEach(x -> x.setDisciplina(this));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public AreaFormacao getAreaFormacao() {
		return areaFormacao;
	}

	public void setAreaFormacao(AreaFormacao areaFormacao) {
		this.areaFormacao = areaFormacao;
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", areaFormacao=" + areaFormacao
				+ ", assunto=" + assunto + "]";
	}
	
	

}
