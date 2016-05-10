package br.ufpr.tcc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.spd.model.Aluno;
import br.com.spd.model.Pessoa;
import br.ufpr.tcc.service.CepHandler;
import br.ufpr.tcc.service.handler.AlunoServiceHandler;
import br.ufpr.tcc.service.handler.impl.AlunoServiceHandlerImpl;

@ViewScoped
@ManagedBean(name = "alunoBean")
public class AlunoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Aluno> listAluno;
	private Aluno alunoSelecionado;
	private Aluno aluno;
	private Pessoa responsavel;
	private List<Pessoa> listaResponsavel;
	private Pessoa pai;
	private Pessoa mae;
	private CepHandler cepHandler;
	private String nome;
	private AlunoServiceHandler AlunoServiceHandler;
	
	

	@PostConstruct
	public void init(){
		listAluno = new ArrayList<>();
		alunoSelecionado = new Aluno();
		aluno = new Aluno();
		pai = new Pessoa();
		mae = new Pessoa();
		responsavel = new Pessoa();
		listaResponsavel = new ArrayList<>();
		cepHandler = new CepHandler();
		AlunoServiceHandler = new AlunoServiceHandlerImpl();
	}
	
	public List<Pessoa> getListaResponsavel() {
		return listaResponsavel;
	}

	public void setListaResponsavel(List<Pessoa> listaResponsavel) {
		this.listaResponsavel = listaResponsavel;
	}

	public void buscaCEP(){
		try{
			cepHandler.getEndereco(aluno);
		}catch (Exception e){
			FacesContext.getCurrentInstance().addMessage("messageAluno", new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", e.getMessage()));
		}
	}
	
	public void incluiResponsavel(){
		
	}
	
	public void buscaAluno(){
		listAluno = AlunoServiceHandler.findByNome(nome).getList();
	}
	
	public void selecionaAluno(){
		aluno = alunoSelecionado;
	}
	
	public void salva(){
		
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
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



	public Pessoa getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Pessoa responsavel) {
		this.responsavel = responsavel;
	}

	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getListAluno() {
		return listAluno;
	}

	public void setListAluno(List<Aluno> listAluno) {
		this.listAluno = listAluno;
	}

	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}
	
}
