package qiquestoes.persistence.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "tbl_area_formacao", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class AreaFormacao extends BaseAFormacaoDisciplinaAssunto<Long> {

	private static final long serialVersionUID = 4363125340287518187L;

	@OneToMany(mappedBy = "areaFormacao", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Disciplina> disciplina;

}
