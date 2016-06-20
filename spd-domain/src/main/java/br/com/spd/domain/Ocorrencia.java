package br.com.spd.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the ocorrencia database table.
 * 
 */
@Entity
@NamedQuery(name="Ocorrencia.findAll", query="SELECT o FROM Ocorrencia o")
public class Ocorrencia implements Serializable, Domain {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="pk_Ocorrencia",sequenceName="ocorrencia_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="pk_Ocorrencia")
	private Long idocorrencia;
	private Date data;
	private String descricao;

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