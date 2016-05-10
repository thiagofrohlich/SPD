package br.ufpr.tcc.service.handler.impl;

import br.com.spd.model.Aluno;
import br.com.spd.wrapper.AlunoWrapper;
import br.ufpr.tcc.service.handler.AlunoServiceHandler;

public class AlunoServiceHandlerImpl extends AbstractServiceHandler<Aluno, Integer> implements AlunoServiceHandler{

	@Override
	public String getRelativePath() {
		return "/Aluno";
	}

	@Override
	public AlunoWrapper findByNome(String nome) {
		
		return (AlunoWrapper) getRestTemplate().getForObject(getPath()+"/nome/{nome}", AlunoWrapper.class, nome);
	}
	
	

}
