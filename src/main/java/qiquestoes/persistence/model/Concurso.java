package qiquestoes.persistence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "tbl_concurso", uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "nome" }) })
public class Concurso extends BaseModel<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2697091001665057435L;

	@Column(name = "data_aplicacao_prova", nullable = false)
	private Date dataAplicacaoProva;
	
	@OneToMany(mappedBy = "concurso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	//@JsonManagedReference
	private List<Prova> prova;


}
