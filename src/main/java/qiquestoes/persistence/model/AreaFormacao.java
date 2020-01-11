package qiquestoes.persistence.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@Table(name = "tbl_area_formacao", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class AreaFormacao extends BaseModel<Long> {

	private static final long serialVersionUID = 4363125340287518187L;

	@OneToMany(mappedBy = "areaFormacao", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	//@JsonManagedReference
	private List<Disciplina> disciplina;

}
