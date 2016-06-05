package br.ufpr.tcc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.spd.model.Aluno;
import br.com.spd.model.Responsavel;
import br.com.spd.model.Turma;
import br.ufpr.tcc.service.CepHandler;
import br.ufpr.tcc.service.handler.AlunoServiceHandler;
import br.ufpr.tcc.service.handler.ResponsavelServiceHandler;
import br.ufpr.tcc.service.handler.TurmaServiceHandler;
import br.ufpr.tcc.service.handler.impl.AlunoServiceHandlerImpl;
import br.ufpr.tcc.service.handler.impl.ResponsavelServiceHandlerImpl;
import br.ufpr.tcc.service.handler.impl.TurmaServiceHandlerImpl;

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
	private Responsavel responsavel;
	private List<Responsavel> listaResponsavel;
	private List<Turma> lstTurma;
	private Responsavel pai;
	private Responsavel mae;
	private CepHandler cepHandler;
	private String nome;
	private AlunoServiceHandler alunoServiceHandler;
	private Long mat = (long) 100000000;
	private ResponsavelServiceHandler responsavelServiceHandler;
	private ResourceBundle rb;
	private TurmaServiceHandler turmaServiceHandler;

	@PostConstruct
	public void init(){
		listAluno = new ArrayList<>();
		alunoSelecionado = new Aluno();
		aluno = new Aluno();
		aluno.setTurma(new Turma());
		pai = new Responsavel();
		mae = new Responsavel();
		responsavel = new Responsavel();
		listaResponsavel = new ArrayList<>();
		cepHandler = new CepHandler();
		alunoServiceHandler = new AlunoServiceHandlerImpl();
		responsavelServiceHandler = new ResponsavelServiceHandlerImpl();
		turmaServiceHandler = new TurmaServiceHandlerImpl();
		lstTurma = turmaServiceHandler.findAll().getList();
		rb = ResourceBundle.getBundle("msg");
	}
	
	public List<Responsavel> getListaResponsavel() {
		return listaResponsavel;
	}

	public void setListaResponsavel(List<Responsavel> listaResponsavel) {
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
		listaResponsavel.add(responsavel);
		responsavel = new Responsavel();
	}
	
	public void deletaResponsavel(Responsavel responsavel){
		listaResponsavel.remove(responsavel);
	}
	
	public void buscaAluno(){
		listAluno = alunoServiceHandler.findByNome(nome).getList();
	}
	
	public void selecionaAluno(){
		aluno = alunoSelecionado;
	}
	
	public void salva(){
		try{
			mat++;
			aluno.setMatricula(mat);
			alunoServiceHandler.create(aluno);
			pai.setAluno(aluno);
			mae.setAluno(aluno);
			responsavelServiceHandler.create(mae);
			responsavelServiceHandler.create(pai);
			FacesContext.getCurrentInstance().addMessage("messageAluno", new FacesMessage(FacesMessage.SEVERITY_INFO, "", rb.getString("salvaAlunoSuccess")));
			aluno = new Aluno();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage("messageAluno", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", rb.getString("salvaAlunoFailure")));
		}
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

	public Responsavel getPai() {
		return pai;
	}


	public void setPai(Responsavel pai) {
		this.pai = pai;
	}


	public Responsavel getMae() {
		return mae;
	}


	public void setMae(Responsavel mae) {
		this.mae = mae;
	}



	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
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
	
	public List<Turma> getLstTurma() {
		return lstTurma;
	}
	
	public void setLstTurma(List<Turma> lstTurma) {
		this.lstTurma = lstTurma;
	}

	
}
