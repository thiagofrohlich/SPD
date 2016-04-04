package br.com.spd.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ocorrencia database table.
 * 
 */
@Entity
@NamedQuery(name="Ocorrencia.findAll", query="SELECT o FROM Ocorrencia o")
public class Ocorrencia implements Serializable, Domain {
	private static final long serialVersionUID = 1L;
	private Long idocorrencia;
	private Date data;
	private String descricao;
	private String tipo;
	private Aluno aluno;

	public Ocorrencia() {
	}


	@Id
	public Long getIdocorrencia() {
		return this.idocorrencia;
	}

	public void setIdocorrencia(Long idocorrencia) {
		this.idocorrencia = idocorrencia;
	}


	@Temporal(TemporalType.DATE)
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


	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="matricula")
	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}