package br.com.spd.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ocorrencia implements Serializable, Model {
	private static final long serialVersionUID = 1L;
	private Long idocorrencia;
	private Date data;
	private String descricao;
	private Aluno aluno;
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
		return tipoOcorrencia;
	}


	public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}

}