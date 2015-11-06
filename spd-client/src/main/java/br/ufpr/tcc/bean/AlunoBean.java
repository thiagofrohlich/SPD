package br.ufpr.tcc.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.spd.model.Aluno;
import br.com.spd.model.Pessoa;
import br.ufpr.tcc.service.CepHandler;

@ViewScoped
@ManagedBean(name = "alunoBean")
public class AlunoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Aluno aluno;
	private Pessoa pessoa;
	private Pessoa pai;
	private Pessoa mae;
	private CepHandler cepHandler;
	
	
	public void buscaCEP(){
		try{
			cepHandler.getEndereco(aluno);
		}catch (Exception e){
			FacesContext.getCurrentInstance().addMessage("messageAluno", new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", e.getMessage()));
		}
	}


	public Pessoa getPai() {
		return pai;
	}


	public void setPai(Pessoa pai) {
		this.pai = pai;
	}


	public Pessoa getMae() {
		return mae;
	}


	public void setMae(Pessoa mae) {
		this.mae = mae;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
}
