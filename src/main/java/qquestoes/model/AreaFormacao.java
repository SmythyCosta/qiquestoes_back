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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_area_formacao", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class AreaFormacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6498195263092129394L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@OneToMany(mappedBy = "areaFormacao", cascade = CascadeType.ALL)
	private Set<Disciplina> disciplina;

	public AreaFormacao(String nome, String descricao, Disciplina disciplina) {
		this.nome = nome;
		this.descricao = descricao;
		this.disciplina = Stream.of(disciplina).collect(Collectors.toSet());
		this.disciplina.forEach(x -> x.setAreaFormacao(this));
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

	public Set<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Set<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "AreaFormacao [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", disciplina=" + disciplina
				+ "]";
	}
	
	

}
