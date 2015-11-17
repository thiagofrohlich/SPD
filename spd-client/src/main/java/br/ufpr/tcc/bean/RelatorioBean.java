package br.ufpr.tcc.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spd.model.Aluno;

@ViewScoped
@ManagedBean(name = "relatorioBean")
public class RelatorioBean {

	
	private Aluno alunoSelecionado;
	private List<Aluno> lstAluno;
	
	@PostConstruct
	public void init(){
		
	}
}
