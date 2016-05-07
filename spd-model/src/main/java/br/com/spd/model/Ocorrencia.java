package br.com.spd.model;

import java.io.Serializable;
import java.util.Date;


public class Ocorrencia implements Serializable, Model {
	private static final long serialVersionUID = 1L;
	private Long idocorrencia;
	private Date data;
	private String descricao;
	private String tipo;
	private Aluno aluno;

	public Ocorrencia() {
	}


	public Long getIdocorrencia() {
		return this.idocorrencia;
	}

	public void setIdocorrencia(Long idocorrencia) {
		this.idocorrencia = idocorrencia;
	}


	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}