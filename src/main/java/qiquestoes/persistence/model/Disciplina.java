package qiquestoes.persistence.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "tbl_disciplina", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class Disciplina extends BaseAFormacaoDisciplinaAssunto<Long> {

	private static final long serialVersionUID = -7936053423990614312L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private AreaFormacao areaFormacao;
	
	@OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Assunto> assunto;
	
}
