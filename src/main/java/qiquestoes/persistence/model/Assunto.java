package qiquestoes.persistence.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;


/*
 * https://projectlombok.org/features/all
 * 
 * @Data
 *	All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, 
 *  and @Setter on all non-final fields, and @RequiredArgsConstructor!
 * */

@Entity
@Table(name = "tbl_assunto", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class Assunto extends BaseAFormacaoDisciplinaAssunto<Long> {

	private static final long serialVersionUID = -7586422742650973469L;

	@ManyToOne(fetch = FetchType.EAGER)
	private Disciplina disciplina;


	public Assunto() {
		// TODO Auto-generated constructor stub
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
}

