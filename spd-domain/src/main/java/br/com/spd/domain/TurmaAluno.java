package br.com.spd.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the turma_aluno database table.
 * 
 */
@Entity
@Table(name="turma_aluno")
@NamedQuery(name="TurmaAluno.findAll", query="SELECT t FROM TurmaAluno t")
public class TurmaAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TurmaAlunoPK id;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="aluno_id", insertable = false, updatable = false)
	private Aluno aluno;

	//bi-directional many-to-one association to Turma
	@ManyToOne
	@JoinColumn(name="turma_id", insertable = false, updatable = false)
	private Turma turma;

	public TurmaAluno() {
	}

	public TurmaAlunoPK getId() {
		return this.id;
	}

	public void setId(TurmaAlunoPK id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return this.turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}