package br.ufpr.tcc.service.handler;

public interface RelatorioServiceHandler extends ServiceHandler<Integer, Integer>{

	String getRelativePath();

	byte[] getAlunoPorTurma(Long turma);

	byte[] getOcorrenciaAluno(Long aluno);

	byte[] getOcorrenciaTurma(Long turma);

	byte[] getAvaliacaoTurma(Long turma, String trimestre, String ano);

	byte[] getavaliacaoAluno(Long turma, Long aluno, String trimestre);
}
