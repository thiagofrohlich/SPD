package br.com.spd.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer codpessoa;
	private String celular;
	private String cpf;
	private String escolaridade;
	private double localtrabalho;
	private String nome;
	private String parentesco;
	private String profissao;
	private Boolean responsavel;
	private String rg;
	private String telefone;
	private Aluno aluno;

	public Pessoa() {
	}


	@Id
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


	public double getLocaltrabalho() {
		return this.localtrabalho;
	}

	public void setLocaltrabalho(double localtrabalho) {
		this.localtrabalho = localtrabalho;
	}


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}


	public String getProfissao() {
		return this.profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}


	public Boolean getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(Boolean responsavel) {
		this.responsavel = responsavel;
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


	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="codaluno")
	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}