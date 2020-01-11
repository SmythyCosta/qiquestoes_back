package qiquestoes.persistence.model;

import java.util.Date;
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
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tbl_disciplina", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class Disciplina extends BaseModel<Long> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3039315388899294092L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private AreaFormacao areaFormacao;
	
	@OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	//@JsonManagedReference
	private List<Assunto> assunto;
	
}
