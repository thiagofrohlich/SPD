package br.com.spd.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the turma database table.
 * 
 */
@Entity
@NamedQuery(name="Turma.findAll", query="SELECT t FROM Turma t")
public class Turma implements Serializable, Domain {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String descricao;

	public Turma() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}