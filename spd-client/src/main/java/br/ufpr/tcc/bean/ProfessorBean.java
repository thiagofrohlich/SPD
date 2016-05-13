package br.ufpr.tcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spd.model.Professor;


@ViewScoped
@ManagedBean(name = "professorBean")
public class ProfessorBean {

	private Professor professor;
	private List<Professor> listProfessor;
	private Professor professorSelecionado;
	
	@PostConstruct
	public void init(){
		professor = new Professor();
		listProfessor = new ArrayList<>();
		professorSelecionado = new Professor();
	}

	public void buscaProfessor(){
		
	}
	
	public void selecionaProfessor(){
		professor = professorSelecionado;
		professorSelecionado = new Professor();
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
}
