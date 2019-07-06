package qiquestoes.persistence.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/*
 * https://projectlombok.org/features/all
 * 
 * @Data
 *	All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, 
 *  and @Setter on all non-final fields, and @RequiredArgsConstructor!
 * */
@Entity
@Table(name = "tbl_disciplina", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class Disciplina extends BaseAFormacaoDisciplinaAssunto<Long> {

	private static final long serialVersionUID = -7936053423990614312L;

	@ManyToOne(fetch = FetchType.EAGER)
	private AreaFormacao areaFormacao;
	
	@OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Assunto> assunto;

	public Disciplina() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Disciplina [areaFormacao=" + areaFormacao + ", assunto=" + assunto + "]";
	}
	
	
}
