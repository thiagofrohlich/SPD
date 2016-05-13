package br.com.spd.model;

import java.io.Serializable;


public class TipoOcorrencia implements Serializable, Model {
	private static final long serialVersionUID = 1L;

	private Integer idTipoOcorrencia;
	private String descricao;

	public TipoOcorrencia() {
	}

	public Integer getIdTipoOcorrencia() {
		return this.idTipoOcorrencia;
	}

	public void setIdTipoOcorrencia(Integer idTipoOcorrencia) {
		this.idTipoOcorrencia = idTipoOcorrencia;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}