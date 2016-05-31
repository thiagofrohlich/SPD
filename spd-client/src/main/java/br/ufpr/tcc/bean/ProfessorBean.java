package br.ufpr.tcc.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.spd.model.Professor;
import br.ufpr.tcc.service.CepHandler;
import br.ufpr.tcc.service.handler.ProfessorServiceHandler;
import br.ufpr.tcc.service.handler.impl.ProfessorServiceHandlerImpl;


@ViewScoped
@ManagedBean(name = "professorBean")
public class ProfessorBean {

	private String name;
	private Professor professor;
	private List<Professor> listProfessor;
	private Professor professorSelecionado;
	private CepHandler cepHandler;
	private ProfessorServiceHandler professorServiceHandler;
	private ResourceBundle rb;
	
	@PostConstruct
	public void init(){
		professor = new Professor();
		listProfessor = new ArrayList<>();
		professorSelecionado = new Professor();
		cepHandler = new CepHandler();
		professorServiceHandler = new ProfessorServiceHandlerImpl();
		rb = ResourceBundle.getBundle("msg");
	}

	public void buscaProfessor(){
		listProfessor = professorServiceHandler.findByName(name).getList();
	}
	
	public void selecionaProfessor(){
		professor = professorSelecionado;
		professorSelecionado = new Professor();
	}
	
	public void buscaCEP(){
		try{
			cepHandler.getEndereco(professor);
		}catch (Exception e){
			FacesContext.getCurrentInstance().addMessage("messageAluno", new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", e.getMessage()));
		}
	}
	
	public void salva(){
		try{
			professorServiceHandler.create(professor);
			FacesContext.getCurrentInstance().addMessage("messageProfessor", new FacesMessage(FacesMessage.SEVERITY_INFO, "", rb.getString("salvaProfessorSuccess")));
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage("messageProfessor", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", rb.getString("salvaProfessorFailure")));
		}
	}
	
	public Professor getProfessor() {
		return professor;
	}

	
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getListProfessor() {
		return listProfessor;
	}

	public void setListProfessor(List<Professor> listProfessor) {
		this.listProfessor = listProfessor;
	}

	public Professor getProfessorSelecionado() {
		return professorSelecionado;
	}

	public void setProfessorSelecionado(Professor professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
