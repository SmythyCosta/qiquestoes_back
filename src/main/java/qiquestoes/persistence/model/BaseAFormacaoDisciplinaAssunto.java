package qiquestoes.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class BaseAFormacaoDisciplinaAssunto<ID extends Serializable> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private ID id;

	@Column(name = "nome", nullable = false)
	private String nome;

}
