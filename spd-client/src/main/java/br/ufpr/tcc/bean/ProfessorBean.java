package br.ufpr.tcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spd.model.Pessoa;

@ViewScoped
@ManagedBean(name = "professorBean")
public class ProfessorBean {

	private Pessoa professor;
	private List<Pessoa> listProfessor;
	private Pessoa professorSelecionado;
	
	@PostConstruct
	public void init(){
		professor = new Pessoa();
		listProfessor = new ArrayList<>();
		professorSelecionado = new Pessoa();
	}

	public void buscaProfessor(){
		
	}
	
	public void selecionaProfessor(){
		professor = professorSelecionado;
		professorSelecionado = new Pessoa();
	}
	
	public Pessoa getProfessor() {
		return professor;
	}

	public void setProfessor(Pessoa professor) {
		this.professor = professor;
	}

	public List<Pessoa> getListProfessor() {
		return listProfessor;
	}

	public void setListProfessor(List<Pessoa> listProfessor) {
		this.listProfessor = listProfessor;
	}

	public Pessoa getProfessorSelecionado() {
		return professorSelecionado;
	}

	public void setProfessorSelecionado(Pessoa professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}
}
