package br.ufpr.tcc.service.handler.impl;

import br.ufpr.tcc.service.handler.RelatorioServiceHandler;

public class RelatorioServiceHandlerImpl extends AbstractServiceHandler<Integer, Integer> implements RelatorioServiceHandler {
	
	
	@Override
	public String getRelativePath() {
		return "/relatorio";
	}
	
	@Override
	public byte[] getAlunoPorTurma(Long turma) {
		return   getRestTemplate().getForObject(getPath()+"/alunoTurma/{turma}", byte[].class,turma);
	}
	
	@Override
	public byte[] getOcorrenciaAluno(Long aluno) {
		return   getRestTemplate().getForObject(getPath()+"/ocorrenciaAluno/{aluno}", byte[].class,aluno);
	}
	
	@Override
	public byte[] getOcorrenciaTurma(Long turma) {
		return   getRestTemplate().getForObject(getPath()+"/ocorrenciaAluno/{aluno}", byte[].class, turma);
	}
	
	@Override
	public byte[] getAvaliacaoTurma(Long turma) {
		return   getRestTemplate().getForObject(getPath()+"/avaliacaoTurma/{aluno}", byte[].class, turma);
	}
	
	@Override
	public byte[] getavaliacaoAluno(Long turma, Long aluno) {
		return   getRestTemplate().getForObject(getPath()+"/avalaicaoAluno/{aluno}/turma/{turma}", byte[].class, aluno, turma);
	}
	
	
	
}
