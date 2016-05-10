package br.ufpr.tcc.service.handler;

import br.com.spd.model.Aluno;
import br.com.spd.wrapper.AlunoWrapper;

public interface AlunoServiceHandler extends ServiceHandler<Aluno, Integer>{

	AlunoWrapper findByNome(String nome);
}
