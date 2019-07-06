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

@Data
@Entity
@Table(name = "tbl_disciplina", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class Disciplina extends BaseAFormacaoDisciplinaAssunto<Long> {

	private static final long serialVersionUID = -7936053423990614312L;

	@ManyToOne(fetch = FetchType.EAGER)
	private AreaFormacao areaFormacao;
	
	@OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Assunto> assunto;

}
