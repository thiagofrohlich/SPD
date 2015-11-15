package br.ufpr.tcc.service.handler.impl;

import java.util.List;

import br.com.spd.model.Aluno;
import br.ufpr.tcc.service.handler.AlunoServiceHandler;

public class AlunoServiceHandlerImpl extends AbstractServiceHandler<Aluno, Integer> implements AlunoServiceHandler{

	@Override
	public String getRelativePath() {
		return "/Aluno";
	}

	@Override
	public List<Aluno> findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
