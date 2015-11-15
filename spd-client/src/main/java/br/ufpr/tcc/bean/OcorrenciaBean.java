package br.ufpr.tcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spd.model.Aluno;
import br.com.spd.model.Ocorrencia;
import br.com.spd.model.Tipo;

@ViewScoped
@ManagedBean(name = "ocorrenciaBean")
public class OcorrenciaBean {
	
	private Aluno alunoSelecionado;
	private List<Tipo> lstTipo;
	private List<Aluno> lstAluno;
	private Ocorrencia ocorrencia;
	private boolean alunoFound;
	
	@PostConstruct
	public void init(){
		alunoSelecionado = new Aluno();
		lstAluno = new ArrayList<>();
		lstTipo = new ArrayList<>();
		alunoFound = false;
	}
	
	public void buscaAluno(){
		
	}
	
	public void selecionaAluno(){
		
	}

	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}

	public List<Aluno> getLstAluno() {
		return lstAluno;
	}

	public void setLstAluno(List<Aluno> lstAluno) {
		this.lstAluno = lstAluno;
	}

	public List<Tipo> getLstTipo() {
		return lstTipo;
	}

	public void setLstTipo(List<Tipo> lstTipo) {
		this.lstTipo = lstTipo;
	}

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public boolean isAlunoFound() {
		return alunoFound;
	}

	public void setAlunoFound(boolean alunoFound) {
		this.alunoFound = alunoFound;
	}
}
