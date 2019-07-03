package qiquestoes.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_disciplina", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class Disciplina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6426311325596834090L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@ManyToOne(fetch = FetchType.EAGER)
	private AreaFormacao areaFormacao;
	@OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Assunto> assunto;
	
	
	public Disciplina() {
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

	public AreaFormacao getAreaFormacao() {
		return areaFormacao;
	}

	public void setAreaFormacao(AreaFormacao areaFormacao) {
		this.areaFormacao = areaFormacao;
	}

	public List<Assunto> getAssunto() {
		return assunto;
	}

	public void setAssunto(List<Assunto> assunto) {
		this.assunto = assunto;
	}
	

}
