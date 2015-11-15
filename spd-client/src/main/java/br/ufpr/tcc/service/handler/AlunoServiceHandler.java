package br.ufpr.tcc.service.handler;

import java.util.List;

import br.com.spd.model.Aluno;

public interface AlunoServiceHandler extends ServiceHandler<Aluno, Integer>{

	List<Aluno> findByNome(String nome);
}
