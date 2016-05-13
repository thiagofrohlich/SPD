package br.com.spd.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p")
public class Pessoa implements Serializable, Domain {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer codpessoa;
	private String celular;
	private String cpf;
	private String escolaridade;
	private String localtrabalho;
	private String nome;
	private String profissao;
	private String rg;
	private String telefone;

	public Pessoa() {
	}

	public Integer getCodpessoa() {
		return this.codpessoa;
	}

	public void setCodpessoa(Integer codpessoa) {
		this.codpessoa = codpessoa;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEscolaridade() {
		return this.escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getLocaltrabalho() {
		return this.localtrabalho;
	}

	public void setLocaltrabalho(String localtrabalho) {
		this.localtrabalho = localtrabalho;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return this.profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}