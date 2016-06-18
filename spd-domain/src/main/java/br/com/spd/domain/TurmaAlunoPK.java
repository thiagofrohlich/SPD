package br.com.spd.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the turma_aluno database table.
 * 
 */
@Embeddable
public class TurmaAlunoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="turma_id", insertable=false, updatable=false)
	private Long turmaId;

	@Column(name="aluno_id", insertable=false, updatable=false)
	private Long alunoId;

	private String ano;

	public TurmaAlunoPK() {
	}
	public Long getTurmaId() {
		return this.turmaId;
	}
	public void setTurmaId(Long turmaId) {
		this.turmaId = turmaId;
	}
	public Long getAlunoId() {
		return this.alunoId;
	}
	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}
	public String getAno() {
		return this.ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TurmaAlunoPK)) {
			return false;
		}
		TurmaAlunoPK castOther = (TurmaAlunoPK)other;
		return 
			this.turmaId.equals(castOther.turmaId)
			&& this.alunoId.equals(castOther.alunoId)
			&& this.ano.equals(castOther.ano);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.turmaId.hashCode();
		hash = hash * prime + this.alunoId.hashCode();
		hash = hash * prime + this.ano.hashCode();
		
		return hash;
	}
}