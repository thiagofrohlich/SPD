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
	public byte[] getAvaliacaoTurma(Long turma, String trimestre, String ano) {
		return   getRestTemplate().getForObject(getPath()+"/avaliacaoTurma/{aluno}/trimestre/{trimestre}/ano/{ano}", byte[].class, turma, trimestre, ano);
	}
	
	@Override
	public byte[] getavaliacaoAluno(Long turma, Long aluno, String trimestre) {
		return   getRestTemplate().getForObject(getPath()+"/avaliacaoAluno/{aluno}/turma/{turma}/trimestre/{trimestre}", byte[].class, aluno, turma, trimestre);
	}

	@Override
	public byte[] getAlunoTipoOcorrencia(Integer tipo) {
		return getRestTemplate().getForObject(getPath()+"/AlunoTipoOcorrencia/{tipo}", byte[].class, tipo);
	}
	
	
	
}
