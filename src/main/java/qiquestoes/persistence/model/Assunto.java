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
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tbl_assunto", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class Assunto extends BaseModel<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1961100686973749376L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Disciplina disciplina;
	
	@OneToMany(mappedBy = "assunto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	//@JsonManagedReference
	private List<Pergunta> pergunta;

}
