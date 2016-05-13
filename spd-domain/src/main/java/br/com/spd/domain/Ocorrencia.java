package br.com.spd.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the ocorrencia database table.
 * 
 */
@Entity
@NamedQuery(name="Ocorrencia.findAll", query="SELECT o FROM Ocorrencia o")
public class Ocorrencia implements Serializable, Domain {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long idocorrencia;
	private Date data;
	private String descricao;
	private String tipo;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="matricula")
	private Aluno aluno;

	//bi-directional many-to-one association to TipoOcorrencia
	@ManyToOne
	@JoinColumn(name="tipo_ocorrencia_id")
	private TipoOcorrencia tipoOcorrencia;

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

	public TipoOcorrencia getTipoOcorrencia() {
		return this.tipoOcorrencia;
	}

	public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}
}