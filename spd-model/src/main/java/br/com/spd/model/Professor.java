package br.com.spd.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Professor extends Pessoa {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Pessoa pessoa;
	private Turma turma;

	public Professor() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Turma getTurma() {
		return this.turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}