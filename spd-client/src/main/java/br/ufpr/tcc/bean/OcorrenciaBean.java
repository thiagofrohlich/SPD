package br.ufpr.tcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spd.model.Aluno;
import br.com.spd.model.Ocorrencia;
import br.com.spd.model.TipoOcorrencia;
import br.ufpr.tcc.service.handler.OcorrenciaServiceHandler;
import br.ufpr.tcc.service.handler.TipoOcorrenciaServiceHandler;
import br.ufpr.tcc.service.handler.impl.OcorrenciaServiceHandlerImpl;
import br.ufpr.tcc.service.handler.impl.TipoOcorrenciaServiceHandlerImpl;

@ViewScoped
@ManagedBean(name = "ocorrenciaBean")
public class OcorrenciaBean {
	
	private Aluno aluno;
	private Aluno alunoSelecionado;
	private List<TipoOcorrencia> lstTipo;
	private Ocorrencia ocorrencia;
	private boolean alunoFound;
	private TipoOcorrenciaServiceHandler tipoOcorrenciaService;
	private OcorrenciaServiceHandler ocorrenciaServiceHandler;
	
	@PostConstruct
	public void init(){
		aluno = new Aluno();
		alunoSelecionado = new Aluno();
		alunoFound = false;
		ocorrencia = new Ocorrencia();
		tipoOcorrenciaService = new TipoOcorrenciaServiceHandlerImpl();
		ocorrenciaServiceHandler = new OcorrenciaServiceHandlerImpl();
		lstTipo = tipoOcorrenciaService.getAll().getList();
	}
	
	
	
	public void selecionaAluno(){
		aluno = alunoSelecionado;
		alunoSelecionado = new Aluno();
	}
	
	public void salva(){
		ocorrencia.setAluno(aluno);
		ocorrenciaServiceHandler.create(ocorrencia);
	}

	
	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}


	public List<TipoOcorrencia> getLstTipo() {
		return lstTipo;
	}

	public void setLstTipo(List<TipoOcorrencia> lstTipo) {
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



	public Aluno getAluno() {
		return aluno;
	}



	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
