package br.com.spd.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Responsavel extends Pessoa {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String parentesco;
	private Boolean responsavel;
	private Aluno aluno;

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

}