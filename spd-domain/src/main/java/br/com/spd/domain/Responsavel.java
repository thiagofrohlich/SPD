package br.com.spd.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the responsavel database table.
 * 
 */
@Entity
@NamedQuery(name="Responsavel.findAll", query="SELECT r FROM Responsavel r")
public class Responsavel implements Serializable, Domain {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="pk_responsavel",sequenceName="responsavel_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="pk_responsavel")
	private Long id;
	private String parentesco;
	private Boolean responsavel;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="codaluno")
	private Aluno aluno;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="codpessoa")
	private Pessoa pessoa;

	public Responsavel() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public Boolean getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(Boolean responsavel) {
		this.responsavel = responsavel;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}