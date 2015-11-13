package br.ufpr.tcc.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
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
	private Pessoa responsavel1;
	private Pessoa responsavel2;
	private Pessoa pai;
	private Pessoa mae;
	private CepHandler cepHandler;
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@PostConstruct
	public void init(){
		aluno = new Aluno();
		pai = new Pessoa();
		mae = new Pessoa();
		responsavel1 = new Pessoa();
		responsavel2 = new Pessoa();
	}
	
	public void buscaCEP(){
		try{
			cepHandler.getEndereco(aluno);
		}catch (Exception e){
			FacesContext.getCurrentInstance().addMessage("messageAluno", new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", e.getMessage()));
		}
	}
	
	public void buscaAluno(){
		
	}
	
	public void salva(){
		
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



	public Pessoa getResponsavel1() {
		return responsavel1;
	}

	public void setResponsavel1(Pessoa responsavel1) {
		this.responsavel1 = responsavel1;
	}

	public Pessoa getResponsavel2() {
		return responsavel2;
	}

	public void setResponsavel2(Pessoa responsavel2) {
		this.responsavel2 = responsavel2;
	}

	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
}
