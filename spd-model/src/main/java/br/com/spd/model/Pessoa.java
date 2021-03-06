package br.com.spd.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({ Professor.class, Responsavel.class })
public abstract class Pessoa implements Serializable, Model {
	private static final long serialVersionUID = 1L;
	protected Long codpessoa;
	protected String celular;
	protected String cpf;
	protected String escolaridade;
	protected String localtrabalho;
	protected String nome;
	protected String profissao;
	protected String rg;
	protected String telefone;

	public Pessoa() {
	}


	public Long getCodpessoa() {
		return this.codpessoa;
	}

	public void setCodpessoa(Long codpessoa) {
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