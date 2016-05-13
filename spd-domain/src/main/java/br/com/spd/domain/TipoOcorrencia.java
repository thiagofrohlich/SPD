package br.com.spd.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tipo_ocorrencia database table.
 * 
 */
@Entity
@Table(name="tipo_ocorrencia")
@NamedQuery(name="TipoOcorrencia.findAll", query="SELECT t FROM TipoOcorrencia t")
public class TipoOcorrencia implements Serializable, Domain {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_ocorrencia")
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