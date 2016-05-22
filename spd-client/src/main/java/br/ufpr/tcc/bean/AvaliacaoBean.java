package br.ufpr.tcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spd.enuns.Notas;
import br.com.spd.model.Aluno;
import br.com.spd.model.AvaliacaoMat2;
import br.com.spd.model.AvaliacaoPre1;
import br.com.spd.model.AvaliacaoPre2;
import br.ufpr.tcc.service.handler.AvaliacaoMatIIServiceHandler;
import br.ufpr.tcc.service.handler.AvaliacaoPreIIServiceHandler;
import br.ufpr.tcc.service.handler.AvaliacaoPreIServiceHandler;
import br.ufpr.tcc.service.handler.impl.AvaliacaoMatIIServiceHandlerImpl;
import br.ufpr.tcc.service.handler.impl.AvaliacaoPreIIServiceHandlerImpl;
import br.ufpr.tcc.service.handler.impl.AvaliacaoPreIServiceHandlerImpl;

@ViewScoped
@ManagedBean(name = "avaliacaoBean")
public class AvaliacaoBean {
	
	private AvaliacaoMat2 mat2;
	private AvaliacaoPre1 pre1;
	private AvaliacaoPre2 pre2;
	private String nome;
	private Aluno alunoSelecionado;
	private boolean renderPre1;
	private boolean renderPre2;
	private boolean renderMat2;
	private List<Aluno> lstAluno;
	private AvaliacaoMatIIServiceHandler avaliacaoMatIIServiceHandler;
	private AvaliacaoPreIServiceHandler avaliacaoPreIServiceHandler;
	private AvaliacaoPreIIServiceHandler avaliacaoPreIIServiceHandler;
	
	
	@PostConstruct
	public void init(){
		mat2 = new AvaliacaoMat2();
		pre1 = new AvaliacaoPre1();
		pre2 = new AvaliacaoPre2();
		alunoSelecionado = new Aluno();
		renderPre1 = false;
		renderPre2 = false;
		renderMat2 = false;
		lstAluno = new ArrayList<>();
		avaliacaoMatIIServiceHandler = new AvaliacaoMatIIServiceHandlerImpl();
		avaliacaoPreIServiceHandler = new AvaliacaoPreIServiceHandlerImpl();
		avaliacaoPreIIServiceHandler = new AvaliacaoPreIIServiceHandlerImpl();
	}
	
	public void selecionaAluno(){
		if(alunoSelecionado.getSerie() == 1){
			renderPre1 = false;
			renderPre2 = false;
			renderMat2 = true;
			mat2.setAluno(alunoSelecionado);
		}
		if (alunoSelecionado.getSerie() == 2) {
			renderPre1 = true;
			renderPre2 = false;
			renderMat2 = false;
			pre1.setAluno(alunoSelecionado);
		}
		if (alunoSelecionado.getSerie() == 3) {
			renderPre1 = false;
			renderPre2 = true;
			renderMat2 = false;
			pre2.setAluno(alunoSelecionado);
		}
	}
	
	
	public void salvaAluno(){
		if(renderMat2){
			avaliacaoMatIIServiceHandler.create(mat2);
		}else 
		if(renderPre1){
			avaliacaoPreIServiceHandler.create(pre1);
		}else
		if(renderPre2){
			avaliacaoPreIIServiceHandler.create(pre2);
		}
	}

	public AvaliacaoMat2 getMat2() {
		return mat2;
	}

	public void setMat2(AvaliacaoMat2 mat2) {
		this.mat2 = mat2;
	}

	public AvaliacaoPre1 getPre1() {
		return pre1;
	}

	public void setPre1(AvaliacaoPre1 pre1) {
		this.pre1 = pre1;
	}

	public AvaliacaoPre2 getPre2() {
		return pre2;
	}

	public void setPre2(AvaliacaoPre2 pre2) {
		this.pre2 = pre2;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isRenderPre1() {
		return renderPre1;
	}

	public void setRenderPre1(boolean renderPre1) {
		this.renderPre1 = renderPre1;
	}

	public boolean isRenderPre2() {
		return renderPre2;
	}

	public void setRenderPre2(boolean renderPre2) {
		this.renderPre2 = renderPre2;
	}

	public boolean isRenderMat2() {
		return renderMat2;
	}

	public void setRenderMat2(boolean renderMat2) {
		this.renderMat2 = renderMat2;
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

	public Notas[] getNotas() {
		return Notas.values();
	}

	
	
}
